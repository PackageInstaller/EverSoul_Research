using System;
using System.ComponentModel.Design;
using System.Data.SqlTypes;
using System.IO;
using dnlib.DotNet;

namespace DNFBDmp {
	class MainClass {
		private static void Main(string[] args) {
			if (args.Length == 0) {
				Console.WriteLine("Usage:");
				Console.WriteLine("\tDNFBDmp.exe <folder to DumyDLLs> [output folder]");
				Console.WriteLine();
				Console.WriteLine("If the output folder is not specified, defaults to 'output' in the current dir");
				return;
			}

			string outputFolder = args.Length >= 2 ? args[1] : @"output/";
			string inputFolder = args[0];
			ModuleContext modCtx = ModuleDef.CreateModuleContext();
			TypeResolver resolver = new();
			foreach (string file in Directory.GetFiles(inputFolder, "*.dll")) {
				Console.WriteLine($"Loading DLL {file}");
				resolver.add(ModuleDefMD.Load(file, modCtx));
			}

		List<TypeDef> flatbufferStructs = resolver.FindFlatbufferStructs();
		
		if (flatbufferStructs.Count == 0) {
			Console.WriteLine("未找到任何FlatBuffer结构体！");
			return;
		}

		Console.WriteLine($"找到 {flatbufferStructs.Count} 个FlatBuffer结构体");
		
		foreach (TypeDef structType in flatbufferStructs) {
			if (structType.Name.EndsWith("Table")) {
				continue;
			}
			MethodDef? createMethod = resolver.FindCreateMethod(structType);
			try {
				FlatbufferDefinition.convert(new ValueTypeSig(structType).RemovePinnedAndModifiers(), resolver);
			} catch (Exception ex) {
				Console.WriteLine($"处理 {structType.Name} 时出错: {ex.Message}");
			}
		}
			Directory.CreateDirectory(outputFolder);
			foreach (FlatbufferDefinition fbDef in FlatbufferDefinition.convTypes.Values)
				fbDef.writeToFile(outputFolder);
		}
	}
}