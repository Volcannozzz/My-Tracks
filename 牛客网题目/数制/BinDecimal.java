package newcoder;

public class BinDecimal
{
	public String printBin(double num)
	{
		String res = "0.";
		double base = 0.5;

		while (num > 0)
		{
			if (num >= base)
			{
				res += "1";
				num -= base;
			} else
				res += "0";

			base /= 2;

			if (res.length() > 34)
			{
				res = "Error";
				break;
			}
		}

		return res;
	}

}
