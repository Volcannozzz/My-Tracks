package newcoder;

import java.util.*;

public class CatDogAsylum
{
	public ArrayList<Integer> asylum(int[][] ope)
	{
		// write code here
		ArrayList<int[]> Falsequeue = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < ope.length; i++)
		{
			if (ope[i][0] == 1)
			{
				Falsequeue.add(ope[i]);
			}

			if (ope[i][0] == 2)
			{
				if (ope[i][1] == 0)
				{
					if (Falsequeue.isEmpty())
					{
						continue;
					} else
					{
						result.add((Falsequeue.remove(0))[1]);
					}
				}

				if (ope[i][1] == 1)// 想要收养狗
				{
					if (Falsequeue.isEmpty())
					{
						continue;
					} else
					{
						for (int t = 0; t < Falsequeue.size(); t++)
						{
							if ((Falsequeue.get(t))[1] > 0)
							{
								result.add((Falsequeue.remove(t))[1]);
								break;
							}
						}
					}
				}

				if (ope[i][1] == -1)// 想要收养猫
				{
					if (Falsequeue.isEmpty())
					{
						continue;
					} else
					{
						for (int t = 0; t < Falsequeue.size(); t++)
						{
							if ((Falsequeue.get(t))[1] < 0)
							{
								result.add((Falsequeue.remove(t))[1]);
								break;
							}
						}
					}

				}

			}
		}

		return result;
	}
}