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

import ghidra.pcode.emu.jit.op.JitFloatLessEqualOp;

/**
 * The generator for a {@link JitFloatLessEqualOp float_lessequal}.
 * 
 * <p>
 * This uses the float comparison operator generator and simply emits {@link #FCMPG} or
 * {@link #DCMPG} depending on the type and then {@link #IFLE}.
 */
public enum FloatLessEqualOpGen implements CompareFloatOpGen<JitFloatLessEqualOp> {
	/** The generator singleton */
	GEN;

	@Override
	public int fcmpOpcode() {
		return FCMPG;
	}

	@Override
	public int dcmpOpcode() {
		return DCMPG;
	}

	@Override
	public int condOpcode() {
		return IFLE;
	}
}
