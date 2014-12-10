package com.homework.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.homework.entity.FunctionInfo;

public class FunctionHandler {
	private List<FunctionInfo> infos = new ArrayList<FunctionInfo>();

	public void loadInfo(String filePath) throws IOException {
		FileReader fr = new FileReader(new File(filePath));
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] tmp = line.split(" ");
			int index = 0;
			while (!tmp[index].startsWith("com"))
				index++;
			FunctionInfo info = new FunctionInfo(tmp[index],
					Integer.parseInt(tmp[index + 1]),
					Integer.parseInt(tmp[index + 2]));
			infos.add(info);
		}
		br.close();
	}

	public String getReferenceCountInfo() {
		String result = "";
		Collections.sort(infos, new Comparator<FunctionInfo>() {

			@Override
			public int compare(FunctionInfo o1, FunctionInfo o2) {
				return Integer.compare(o2.getReferenceCount(),
						o1.getReferenceCount());
			}
		});
		result = getTopTenFunctionName();
		return result;
	}

	public String getReferencedbyCountInfo() {
		String result = "";
		Collections.sort(infos, new Comparator<FunctionInfo>() {

			@Override
			public int compare(FunctionInfo o1, FunctionInfo o2) {
				return Integer.compare(o2.getReferencedbyCount(),
						o1.getReferencedbyCount());
			}
		});
		result = getTopTenFunctionName();
		return result;
	}

	public String getTopTenFunctionName() {
		String result = "";
		int count = 0;
		for (FunctionInfo info : infos) {
			if (count <= 10) {
				result += info.getName() + "\n";
				count++;
			} else
				break;
		}
		return result;
	}
}
