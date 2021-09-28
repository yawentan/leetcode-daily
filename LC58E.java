package yawen;

import org.junit.Test;

public class LC58E {
	@Test
	public void test() {
		lengthOfLastWord("    adc   a    ");
	}
	
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" +");
        return split[split.length-1].length();
    }
}
