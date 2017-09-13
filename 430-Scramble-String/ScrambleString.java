
public class ScrambleString {
	/*
	 * @param s1: A string
	 * 
	 * @param s2: Another string
	 * 
	 * @return: whether s2 is a scrambled string of s1
	 */
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int len = s1.length();
		if (len == 0)
			return true;

		boolean[][][] d = new boolean[len + 1][len][len];
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++)
				if (s1.charAt(i) == s2.charAt(j))
					d[1][i][j] = true;
				else
					d[1][i][j] = false;

		for (int k = 2; k <= len; k++)
			for (int i = 0; i <= len - k; i++)
				for (int j = 0; j <= len - k; j++)
					for (int l = 1; l <= (k - 1); l++) {
						d[k][i][j] = false;
						if (d[l][i][j] && d[k - l][i + l][j + l]) {
							d[k][i][j] = true;
							break;
						} else if (d[l][i][j + k - l] && d[k - l][i + l][j]) {
							d[k][i][j] = true;
							break;
						}
					}

		return d[len][0][0];
	}
}
