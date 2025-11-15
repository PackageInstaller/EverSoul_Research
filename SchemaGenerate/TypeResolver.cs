using dnlib.DotNet;

namespace DNFBDmp {
	// This class is just a manual resolver by iterating through the modules
	// and finding the right definition.
	// Maybe there was a way to do it with the module context in dnlib
	// but i couldn't get it to work, i might be dumb.
	public class TypeResolver {
		private List<ModuleDef> modules;

		public TypeResolver() {
			this.modules = [];
		}

		public void add(ModuleDef module) {
			this.modules.Add(module);
		}

		public TypeDef? Find(string fullName, bool isReflectionName) {
			foreach (ModuleDef mod in this.modules) {
				TypeDef td = mod.Find(fullName, isReflectionName);
				if (td != null)
					return td;
			}
			return null;
		}

		public TypeDef? Find(TypeRef typeRef) {
			foreach (ModuleDef mod in this.modules) {
				TypeDef td = mod.Find(typeRef);
				if (td != null)
					return td;
			}
			return null;
		}

		public TypeDef? Find(ITypeDefOrRef typeRef) {
			foreach (ModuleDef mod in this.modules) {
				TypeDef td = mod.Find(typeRef);
				if (td != null)
					return td;
			}
			return null;
		}

		// IFlatbufferObject接口
		public List<TypeDef> FindFlatbufferStructs() {
			List<TypeDef> flatbufferStructs = [];
			
			foreach (ModuleDef mod in this.modules) {
				foreach (TypeDef type in mod.Types) {
					if (type.Namespace != "TBL")
						continue;
					
					if (!type.IsValueType || type.IsEnum)
						continue;
					
					bool implementsIFlatbufferObject = false;
					foreach (InterfaceImpl iface in type.Interfaces) {
						if (iface.Interface.Name == "IFlatbufferObject") {
							implementsIFlatbufferObject = true;
							break;
						}
					}
					
					if (implementsIFlatbufferObject) {
						Console.WriteLine($"找到FlatBuffer结构: {type.FullName}");
						flatbufferStructs.Add(type);
					}
				}
			}
			
			return flatbufferStructs;
		}

		public MethodDef? FindCreateMethod(TypeDef structType) {
			string createMethodName = $"Create{structType.Name}";
			
			foreach (MethodDef method in structType.Methods) {
				if (method.Name == createMethodName && method.IsStatic && method.IsPublic) {
					return method;
				}
			}
			
			return null;
		}
	}
}