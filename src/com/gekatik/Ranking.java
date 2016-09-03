package com.gekatik;
public class Ranking
{
  public static double[] getEstimations(double paramDouble1, double paramDouble2)
  {
    double[] arrayOfDouble = new double[2];
    double d1 = 1.0D / (1.0D + Math.pow(10.0D, (paramDouble2 - paramDouble1) / 400.0D));
    double d2 = 1.0D / (1.0D + Math.pow(10.0D, (paramDouble1 - paramDouble2) / 400.0D));
    arrayOfDouble[0] = d1;
    arrayOfDouble[1] = d2;
    return arrayOfDouble;
  }

  public static int getConstant(int paramInt)
  {
    if (paramInt < 2000) {
      return 32;
    }
    if (paramInt < 2401) {
      return 24;
    }
    return 16;
  }

  public static int[] getNewRankings(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    double[] arrayOfDouble = new double[2];
    int[] arrayOfInt = new int[2];
    arrayOfDouble = getEstimations(paramInt1, paramInt2);
    int i = (int)(paramInt1 + getConstant(paramInt1) * ((paramBoolean ? 1 : 0) - arrayOfDouble[0]));
    int j = (int)(paramInt2 + getConstant(paramInt2) * ((paramBoolean ? 0 : 1) - arrayOfDouble[1]));
    arrayOfInt[0] = Math.round(i);
    arrayOfInt[1] = Math.round(j);
    return arrayOfInt;
  }
}