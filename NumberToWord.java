import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberToWord {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		int ribuan = n / 1000;
		int ratusan = (n % 1000) / 100;
		int puluhan = (n % 100) / 10;
		int satuan = (n % 10);

		switch(ribuan) {
			case 1:
				System.out.print("Seribu ");
				break;
			case 2:
				System.out.print("Dua ribu ");
				break;
			case 3:
				System.out.print("Tiga ribu ");
				break;
			case 4:
				System.out.print("Empat ribu ");
				break;
			case 5:
				System.out.print("Lima ribu ");
				break;
			case 6:
				System.out.print("Enam ribu ");
				break;
			case 7:
				System.out.print("Tujuh ribu ");
				break;
			case 8:
				System.out.print("Delapan ribu ");
				break;
			case 9:
				System.out.print("Sembilan ribu ");
				break;
		}

		switch(ratusan) {
			case 1:
				System.out.print("seratus ");
				break;
			case 2:
				System.out.print("dua ratus ");
				break;
			case 3:
				System.out.print("tiga ratus ");
				break;
			case 4:
				System.out.print("empat ratus ");
				break;
			case 5:
				System.out.print("lima ratus ");
				break;
			case 6:
				System.out.print("enam ratus ");
				break;
			case 7:
				System.out.print("tujuh ratus ");
				break;
			case 8:
				System.out.print("delapan ratus ");
				break;
			case 9:
				System.out.print("sembilan ratus ");
				break;
		}

		switch(puluhan) {
			case 2:
				System.out.print("dua puluh ");
				break;
			case 3:
				System.out.print("tiga puluh ");
				break;
			case 4:
				System.out.print("empat puluh ");
				break;
			case 5:
				System.out.print("lima puluh ");
				break;
			case 6:
				System.out.print("enam puluh ");
				break;
			case 7:
				System.out.print("tujuh puluh ");
				break;
			case 8:
				System.out.print("delapan puluh ");
				break;
			case 9:
				System.out.print("sembilan puluh ");
				break;
		}

		if (puluhan == 1) {
			switch(satuan) {
				case 1:
					System.out.print("sebelas");
					break;
				case 2:
					System.out.print("dua belas");
					break;
				case 3:
					System.out.print("tiga belas");
					break;
				case 4:
					System.out.print("empat belas");
					break;
				case 5:
					System.out.print("lima belas");
					break;
				case 6:
					System.out.print("enam belas");
					break;
				case 7:
					System.out.print("tujuh belas");
					break;
				case 8:
					System.out.print("delapan belas");
					break;
				case 9:
					System.out.print("sembilan belas");
					break;
			}
		} else {
			switch(satuan) {
				case 1:
					System.out.print("satu");
					break;
				case 2:
					System.out.print("dua");
					break;
				case 3:
					System.out.print("tiga");
					break;
				case 4:
					System.out.print("empat");
					break;
				case 5:
					System.out.print("lima");
					break;
				case 6:
					System.out.print("enam");
					break;
				case 7:
					System.out.print("tujuh");
					break;
				case 8:
					System.out.print("delapan");
					break;
				case 9:
					System.out.print("sembilan");
					break;
			}
		}

		System.out.println();
	}
}