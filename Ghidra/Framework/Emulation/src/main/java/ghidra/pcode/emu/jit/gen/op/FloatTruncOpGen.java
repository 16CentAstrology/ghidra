/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.pcode.emu.jit.gen.op;

import static ghidra.lifecycle.Unfinished.TODO;

import org.objectweb.asm.MethodVisitor;

import ghidra.pcode.emu.jit.analysis.JitControlFlowModel.JitBlock;
import ghidra.pcode.emu.jit.analysis.JitType;
import ghidra.pcode.emu.jit.analysis.JitType.*;
import ghidra.pcode.emu.jit.gen.JitCodeGenerator;
import ghidra.pcode.emu.jit.op.JitFloatTruncOp;

/**
 * The generator for a {@link JitFloatTruncOp float_trunc}.
 * 
 * <p>
 * This uses the unary operator generator and emits {@link #F2I}, {@link #F2L}, {@link #D2I}, or
 * {@link #D2L}.
 */
public enum FloatTruncOpGen implements UnOpGen<JitFloatTruncOp> {
	/** The generator singleton */
	GEN;

	private JitType gen(MethodVisitor rv, int opcode, JitType type) {
		rv.visitInsn(opcode);
		return type;
	}

	@Override
	public JitType generateUnOpRunCode(JitCodeGenerator gen, JitFloatTruncOp op, JitBlock block,
			JitType uType, MethodVisitor rv) {
		JitType outType = op.type().resolve(gen.getTypeModel().typeOf(op.out()));
		return switch (uType) {
			case FloatJitType ut -> switch (outType) {
				case IntJitType ot -> gen(rv, F2I, ot);
				case LongJitType ot -> gen(rv, F2L, ot);
				case MpIntJitType ot -> TODO("MpFloat/Int");
				default -> throw new AssertionError();
			};
			case DoubleJitType ut -> switch (outType) {
				case IntJitType ot -> gen(rv, D2I, ot);
				case LongJitType ot -> gen(rv, D2L, ot);
				case MpIntJitType ot -> TODO("MpFloat/Int");
				default -> throw new AssertionError();
			};
			case MpIntJitType ot -> TODO("MpFloat/Int");
			default -> throw new AssertionError();
		};
	}
}
