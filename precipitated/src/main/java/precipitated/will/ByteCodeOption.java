package precipitated.will;


import org.apache.bcel.generic.GETSTATIC;
import org.apache.bcel.generic.INVOKEVIRTUAL;
import org.mockito.asm.tree.*;
import org.objectweb.asm.ClassReader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by will.wang on 2015/4/21.
 */
public class ByteCodeOption extends InputStream{

    public static void main(String[] args) throws IOException {
//        ByteCodeOption byteCodeOption = new ByteCodeOption();
//        ClassReader classReader = new ClassReader(byteCodeOption);
//        ClassNode classNode = new ClassNode();
//
//        for (Object method : classNode.methods) {
//            MethodNode methodNode = (MethodNode)method;
//
//            InsnList insnList = methodNode.instructions;
//            InsnList insns = new InsnList();
//            insns.add(new FieldInsnNode(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
//            insns.add(new LdcInsnNode("Enter method -> " + methodNode.name));
//            insns.add(new MethodInsnNode(INVOKEVIRTUAL, "java/io/PrintStream",
//                    "println", "(Ljava/lang/String;)V"));
//            insns.insert(insns); methodNode.maxStack += 3;
//        }
    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}
