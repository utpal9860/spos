import java.util.*;
import java.io.*;

class MntTuple1 {
	String name;
	int index;
	
	MntTuple1(String s, int i) {
		name = s;
		index = i;
	}
	
	public String toString() {
		return("[" + name + ", " + index + "]");
	}
}

class passtwomicro {
	static List<MntTuple1> mnt;
	static List<String> mdt;
	static int mntc;
	static int mdtc;
	static int mdtp;
	static BufferedReader input;
	static List<List <String>> ala;
	static Map<String, Integer> ala_macro_binding;
	
	public static void main(String args[]) throws Exception {
		initializeTables();
	
		System.out.println("\n===== PASS 2 =====\n");
		pass2();
	}
	
	static void showAla(int pass) throws Exception {
		PrintWriter out = new PrintWriter(new FileOutputStream("Macrotbl/out_ala_pass" + pass + ".txt"), true);
		for(List l : ala) {
			System.out.println(l);
			out.println(l);
		}
	}
	
	static void pass2() throws Exception {
		input = new BufferedReader(new InputStreamReader(new FileInputStream("Macrotbl/output_pass1.txt")));
		PrintWriter output = new PrintWriter(new FileOutputStream("Macrotbl/output_pass2.txt"), true);
		String token = new String();
		String s;
		while((s = input.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s, " ", false);
			while(st.hasMoreTokens()) {
				token = st.nextToken();
				if(st.countTokens() > 2) {
					token = st.nextToken();
				}
				MntTuple1 x = null;
				for(MntTuple1 m : mnt) {
					if(m.name.equalsIgnoreCase(token)) {
						x = m;
						break;
					}
				}
				if(x != null) {
					mdtp = x.index;
					List<String> l = pass2Ala(s);
					mdtp++;
					String temp = new String();
					while(!(temp = mdt.get(mdtp)).trim().equalsIgnoreCase("MEND")) {
						String line = new String();
						StringTokenizer st2 = new StringTokenizer(temp, " ,",false);
						for(int i=0 ; i<12 ; i++) {
							line += " ";
						}
						String opcode = st2.nextToken();
						line += opcode;
						for(int i=opcode.length() ; i<24 ; i++) {
							line += " ";
						}
						line += st2.nextToken();
						while(st2.hasMoreTokens()) {
							String token2 = st2.nextToken();
							int index;
							if((index = token2.indexOf("#")) != -1) {
								line += "," + l.get(Integer.parseInt(token2.substring(index+1,index+2)));
							}
						}
						mdtp++;
						output.println(line);
						System.out.println(line);
					}
					break;
				} else {
					output.println(s);
					System.out.println(s);
					break;
				}
			}
		}
		System.out.println("\nALA:");
		showAla(2);
	}
	
	static List<String> pass2Ala(String s) {
		StringTokenizer st = new StringTokenizer(s, " ", false);
		int num_tokens = st.countTokens();
		String macro_name = st.nextToken();
		int ala_no = ala_macro_binding.get(macro_name);
		List<String> l = ala.get(ala_no);
		int ctr = 0;
		StringTokenizer st2 = null;
		try {
			st2 = new StringTokenizer(st.nextToken(), ",", false);
			while(st2.hasMoreTokens()) {
				l.set(ctr, st2.nextToken());
				ctr++;
			}
		} catch(Exception e) {
			// do nothing
		}
		if(ctr < num_tokens) {
			String s2 = mdt.get(mdtp);
			StringTokenizer st3 = new StringTokenizer(s2, " ,", false);
			String token = new String();
			int index = 0;
			while(st3.hasMoreTokens()) {
				token = st3.nextToken();
				if((index = token.indexOf("=")) != -1) {
					try {
						l.set(ctr++, token.substring(index+1, token.length()));
					} catch(Exception e) {
						// do nothing
					}
				}
			}
		}
		ala.set(ala_no, l);
		return l;
	}
	
	static void initializeTables() {
		mnt = new LinkedList<>();
		mdt = new ArrayList<>();
		ala = new LinkedList<>();
		mntc = 0;
		mdtc = 0;
		ala_macro_binding = new HashMap<>();
	}
}
