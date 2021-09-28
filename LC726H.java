package yawen;

import java.util.*;

class Node726 implements Comparable<Node726> {
	String Che;
	int cont;


	public Node726(String che, int cont) {
		super();
		Che = che;
		this.cont = cont;
	}


	@Override
	public int compareTo(Node726 o) {
		return this.Che.compareTo(o.Che);
	}


}

public class LC726H {
    public String countOfAtoms(String formula) {
    	int idx = 0;
    	String ans = "";
    	HashMap<String,Integer> hash = new HashMap<>();
    	PriorityQueue<Node726> q = new PriorityQueue<>();
    	ContKH(formula,1,hash);
    	for(String s:hash.keySet()) {
    		int cont = hash.get(s);
    		Node726 node = new Node726(s,cont);
    		q.add(node);
    	}
    	while(!q.isEmpty()) {
    		Node726 temp = q.poll();
    		ans+=temp.Che;
    		if(temp.cont!=1)
    			ans+=String.valueOf(temp.cont);
    	}
    	return ans;
    }

	private void ContKH(String substring, int n, HashMap<String, Integer> hash) {
    	int idx = 0;
    	HashMap<String,Integer> hashlocal = new HashMap<>();
    	String temp = "";
    	while(idx<substring.length()) {
    		char c =  substring.charAt(idx);
    		if(c>='A'&&c<='Z') {
    			if(temp.toString()=="") {
        			temp+=c;
    			}else {
        			if(hashlocal.containsKey(temp)) {
        				int cont = hashlocal.get(temp);
        				hashlocal.put(temp, cont+1);
        			}else {
        				hashlocal.put(temp, 1);
        			}
    				temp = "";
        			temp+=c;
    			}
    		}else if(c>='a'&&c<='z') {
    			temp+=c;
    		}else if(c>='0'&&c<='9') {
    			String num = "";
    			while(idx<substring.length()&&substring.charAt(idx)>='0'&&substring.charAt(idx)<='9') {
    				c = substring.charAt(idx);
        			num+=c;
    				idx++;
    			}
    			int nnum = Integer.valueOf(num);
    			if(hashlocal.containsKey(temp)) {
    				int cont = hashlocal.get(temp);
    				hashlocal.put(temp, cont+nnum);
    			}else {
    				if(temp=="")
    					System.out.println("Ñ¹¿Õ");
    				hashlocal.put(temp, nnum);
    			}
				temp = "";
				idx--;
    		}else if(c=='(') {
    			if(temp.toString()=="") {
    				
    			}else {
    				if(hashlocal.containsKey(temp)) {
    					int cont = hashlocal.get(temp);
    					hashlocal.put(temp, cont+1);
    				}else {
    					hashlocal.put(temp, 1);
    				}
    				temp = "";
    			}
    			int l = idx;
    			int r = 0;
    			Stack<Character> s = new Stack<>();
    			s.add(c);
    			while(!s.isEmpty()) {
    				idx++;
    				c = substring.charAt(idx);
    				if(c=='(')
    					s.add(c);
    				else if(c==')')
    					s.pop();
    			}
    			r = idx;
    			idx++;
    			String num = "";
    			while(idx<substring.length()&&substring.charAt(idx)>='0'&&substring.charAt(idx)<='9') {
    				c = substring.charAt(idx);
        			num+=c;
    				idx++;
    			}
    			int k;
    			if(num!="")
    				k = Integer.valueOf(num);
    			else
    				k=1;
    			ContKH(substring.substring(l+1, r),k,hashlocal);
				temp = "";
				idx--;
    		}
    		idx++;
    	}
		if(temp.toString()=="") {
			
		}else {
			if(hashlocal.containsKey(temp)) {
				int cont = hashlocal.get(temp);
				hashlocal.put(temp, cont+1);
			}else {
				hashlocal.put(temp, 1);
			}
			temp = "";
		}
    	for(String sb:hashlocal.keySet()) {
    		int co = hashlocal.get(sb);
    		hashlocal.put(sb, co*n);
    		co = hashlocal.get(sb);
    		if(hash.containsKey(sb)) {
        		int hco = hash.get(sb);
    			hash.put(sb, hco+co);
    		}else {
    			hash.put(sb, co);
    		}
    	}
	}
	
	public static void main(String[] args) {
		LC726H lc = new LC726H();
		HashMap<String, Integer> h = new HashMap<>();
		StringBuffer temp = new StringBuffer();
		StringBuffer sb = new StringBuffer();
//		sb.append('O');
//		temp.append('O');
//		h.put(temp.toString(), 1);
//		
//		if(h.containsKey(sb.toString())) {
//			System.out.println("°üº¬");
//		}else {
//			System.out.println("²»°üº¬");
//		}
		System.out.println(lc.countOfAtoms("((Bi16LrSc30As49As23La13La(Ba21Re28BkRf40DbP29SeSe41La27Cn16)48(TcRn)49(Sb28Ti4Po35Mn16)21(Ta36Tl2Br5Dy21S41)6(Bh37Li36O20Tb48)24Cr43Pd11Pu39OgYb43Zr35FmHe44(Rh35BiLaCf4RnHLi10RgLuRg)3(Cn15PbS44Nd18)8)25((Hs11B41Rf46)20(At48Te45)32(Cs15Mt19OgHs34Ts5La33Ga23Np50Dy33O24)4)13((Po21ZnPdK27Pm16TlCo34Nd30Y4N)16(Nh2BaNa28Ga15LuAl38)17(Rb23ReRf2Rf33I32Te48Bh)50(Cf37Ne32W33BeRgIr21Cs34Mc17Zn43)43(Ho23ArEs38Er40Tb8DyIn41Tc36Hg21Cl9)42(Y8B25Ts16S10Fr2Lv22Po6)2(Zn46N34Ds7Sg20HoRf31P25ZrIHo22)40(FeRh50Kr9ThPt49)37(TaLrKr35Kr12SrCd26Xe28Mt26CnFl)43)23)17"));
		System.out.println(lc.countOfAtoms("(H)"));
	}

}
