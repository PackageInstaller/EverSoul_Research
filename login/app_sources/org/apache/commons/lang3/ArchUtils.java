package org.apache.commons.lang3;

import com.liapp.y;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.arch.Processor;

/* loaded from: classes2.dex */
public class ArchUtils {
    private static final Map<String, Processor> ARCH_TO_PROCESSOR = new HashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        init();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void init() {
        init_X86_32Bit();
        init_X86_64Bit();
        init_IA64_32Bit();
        init_IA64_64Bit();
        init_PPC_32Bit();
        init_PPC_64Bit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void init_X86_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.X86), y.ݬֲ֮ܲت(1512976183), y.ٲٴݴ״ٰ(1781668800), y.֬ڱܱײٮ(-1159243719), y.ݮڮֲڭܩ(-628936348), y.ٲٴݴ״ٰ(1781668464), y.ۮڭڭܬި(862153891));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void init_X86_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.X86), y.ۮڭڭܬި(862154587), y.ۮڭڭܬި(862154651), y.֬ڱܱײٮ(-1159243551), y.دײܮڳܯ(2051933285));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void init_IA64_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.IA_64), y.ݬֲ֮ܲت(1512973183), y.ٲٴݴ״ٰ(1781667384));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void init_IA64_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64), y.ݮڮֲڭܩ(-628933324), y.ٴسسݬߨ(1392970186));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void init_PPC_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.PPC), y.ݬֲ֮ܲت(1512972791), y.دײܮڳܯ(2051934437), y.٬ݯح׭٩(575983358), y.ٲٴݴ״ٰ(1781667544), y.ݮڮֲڭܩ(-628933044));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void init_PPC_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.PPC), y.ݮڮֲڭܩ(-628932732), y.֬ڱܱײٮ(-1159243471), y.֬ڱܱײٮ(-1159243415), y.ۮڭڭܬި(862151203), y.֬ڱܱײٮ(-1159244215));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void addProcessor(String str, Processor processor) {
        Map<String, Processor> map = ARCH_TO_PROCESSOR;
        if (map.containsKey(str)) {
            throw new IllegalStateException(y.دײܮڳܯ(2051935701) + str + y.٬ݯح׭٩(575982566));
        }
        map.put(str, processor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void addProcessors(Processor processor, String... strArr) {
        for (String str : strArr) {
            addProcessor(str, processor);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Processor getProcessor() {
        return getProcessor(SystemUtils.OS_ARCH);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Processor getProcessor(String str) {
        return ARCH_TO_PROCESSOR.get(str);
    }
}
