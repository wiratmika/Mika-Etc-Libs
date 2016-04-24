// Custom randomizer for flexible implementation and easier use
// (c) 2015 Wiratmika
// Source:
// http://stackoverflow.com/questions/2863852/how-to-generate-a-random-string-in-java
// http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
import java.util.Random;

class DatabaseRandomizer {
	Random integerRandomizer;

	public static String generateStringFixedLength(int length) {
		Random ran = new Random();
		int top = length - 1;
		char data = ' ';
		String dat = "";

		for (int i = 0; i <= top; i++) {
			data = (char)(ran.nextInt(25)+97);
			dat = data + dat;
		}

		return dat;
	}

	public static int generateInteger(int min, int max) {
		Random integerRandomizer = new Random();

		return integerRandomizer.nextInt((max - min)) + min;
	}

	public static String generateString(int min, int max) {
		return generateStringFixedLength(generateInteger(min, max));
	}

	public static String generateNoTelp() {
		int noTelp = Randomizer.generateInteger(81100, 85699);
		int randomLength = Randomizer.generateInteger(0000, 9999);
		return "0" + Integer.toString(noTelp) + Integer.toString(randomLength);
	}

	public static String generateTgl(int minTahun, int maxTahun) {
		int tgl = Randomizer.generateInteger(1, 20);
		String tanggal = tgl < 10 ? "0" + Integer.toString(tgl) : Integer.toString(tgl);

		int bln = Randomizer.generateInteger(1, 12);
		String bulan = bln < 10 ? "0" + Integer.toString(bln) : Integer.toString(bln);

		int tahun = Randomizer.generateInteger(minTahun, maxTahun + 1);
		return "" + tahun + "-" + bulan + "-" + tanggal;
	}

	public static String generateJam() {
		int jam = Randomizer.generateInteger(1, 23);
		String hour = jam < 10 ? "0" + Integer.toString(jam) : Integer.toString(jam);

		int menit = Randomizer.generateInteger(0, 60);
		String minute = menit < 10 ? "0" + Integer.toString(menit) : Integer.toString(menit);

		int detik = Randomizer.generateInteger(0, 60);
		String second = detik < 10 ? "0" + Integer.toString(detik) : Integer.toString(detik);
		return "" + hour + ":" + minute + ":" + second;
	}

	public static boolean generateBoolean() {
		return generateInteger(1, 10) < 5;
	}
}