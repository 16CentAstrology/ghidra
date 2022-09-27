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
package ghidra.file.formats.android.oat.oatclass;

import java.io.IOException;

import ghidra.app.util.bin.BinaryReader;
import ghidra.file.formats.android.dex.format.ClassDataItem;
import ghidra.program.model.data.DataType;
import ghidra.util.exception.DuplicateNameException;

/**
 * <a href="https://android.googlesource.com/platform/art/+/refs/heads/oreo-m2-release/runtime/oat_file.h#219">oreo-m2-release/runtime/oat_file.h</a>
 */
public class OatClass_OreoM2 extends OatClass_Oreo {

	OatClass_OreoM2(BinaryReader reader, ClassDataItem classDataItem, String oatVersion)
			throws IOException {
		super(reader, classDataItem, oatVersion);
	}

	@Override
	public DataType toDataType() throws DuplicateNameException, IOException {
		DataType dataType = super.toDataType();
		try {
			renameDataType(dataType, OatClass_OreoM2.class.getSimpleName());
		}
		catch (Exception e) {
			//ignore...
		}
		return dataType;
	}

}
