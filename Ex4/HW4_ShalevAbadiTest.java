import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HW4_ShalevAbadiTest {

	@Test
	void testDecToBin_Base10_0_Return_0() {
		//Given
		int base10 = 0;
		
		//when
		int result = HW4_ShalevAbadi.dec2Bin(base10);
		
		//then
		assertEquals(0, result);
	}
	
	@Test
	void testDecToBin_Base10_1_Return_1() {
		//Given
		int base10 = 1;
		
		//when
		int result = HW4_ShalevAbadi.dec2Bin(base10);
		
		//then
		assertEquals(1, result);
	}
	@Test
	void testDecToBin_Base10_2_Return_10() {
		//Given
		int base10 = 2;
		
		//when
		int result = HW4_ShalevAbadi.dec2Bin(base10);
		
		//then
		assertEquals(10, result);
	}
	@Test
	void testDecToBin_Base10_3_Return_11() {
		//Given
		int base10 = 3;
		
		//when
		int result = HW4_ShalevAbadi.dec2Bin(base10);
		
		//then
		assertEquals(11, result);
	}
	
	@Test
	void testDecToBin_Base10_362_Return_101101010() {
		//Given
		int base10 = 362;
		
		//when
		int result = HW4_ShalevAbadi.dec2Bin(base10);
		
		//then
		assertEquals(101101010, result);
	}
	
	@Test
	void testBinToDec_Bin_0_Return_0() {
		//Given
		int bin = 0;
		
		//when
		int result = HW4_ShalevAbadi.bin2Dec(bin);
		
		//then
		assertEquals(0, result);
	}

	@Test
	void testBinToDec_Bin_1_Return_1() {
		//Given
		int bin = 1;
		
		//when
		int result = HW4_ShalevAbadi.bin2Dec(bin);
		
		//then
		assertEquals(1, result);
	}

	@Test
	void testBinToDec_Bin_10_Return_2() {
		//Given
		int bin = 10;
		
		//when
		int result = HW4_ShalevAbadi.bin2Dec(bin);
		
		//then
		assertEquals(2, result);
	}
	
	@Test
	void testBinToDec_Bin_11_Return_3() {
		//Given
		int bin = 11;
		
		//when
		int result = HW4_ShalevAbadi.bin2Dec(bin);
		
		//then
		assertEquals(3, result);
	}

	@Test
	void testBinToDec_Bin_101101010_Return_362() {
		//Given
		int bin = 101101010;
		
		//when
		int result = HW4_ShalevAbadi.bin2Dec(bin);
		
		//then
		assertEquals(362, result);
	}
	

	@Test
	void testHexToDec_Hex_0_Return_0() {
		//Given
		String hex = "0";
		
		//when
		int result = HW4_ShalevAbadi.hex2Dec(hex);
		
		//then
		assertEquals(0, result);
	}
	
	@Test
	void testHexToDec_Hex_1_Return_1() {
		//Given
		String hex = "1";
		
		//when
		int result = HW4_ShalevAbadi.hex2Dec(hex);
		
		//then
		assertEquals(1, result);
	}

	@Test
	void testHexToDec_Hex_7_Return_7() {
		//Given
		String hex = "7";
		
		//when
		int result = HW4_ShalevAbadi.hex2Dec(hex);
		
		//then
		assertEquals(7, result);
	}

	@Test
	void testHexToDec_Hex_B_Return_11() {
		//Given
		String hex = "B";
		
		//when
		int result = HW4_ShalevAbadi.hex2Dec(hex);
		
		//then
		assertEquals(11, result);
	}
	
	@Test
	void testHexToDec_Hex_10_Return_16() {
		//Given
		String hex = "10";
		
		//when
		int result = HW4_ShalevAbadi.hex2Dec(hex);
		
		//then
		assertEquals(16, result);
	}
	
	@Test
	void testHexToDec_Hex_11_Return_17() {
		//Given
		String hex = "11";
		
		//when
		int result = HW4_ShalevAbadi.hex2Dec(hex);
		
		//then
		assertEquals(17, result);
	}

	@Test
	void testDecToHex_Dec_0_Return_0() {
		//Given
		int dec = 0;
		
		//when
		String result = HW4_ShalevAbadi.dec2Hex(dec);
		
		//then
		assertEquals("0", result);
	}
	
	@Test
	void testDecToHex_Dec_1_Return_1() {
		//Given
		int dec = 1;
		
		//when
		String result = HW4_ShalevAbadi.dec2Hex(dec);
		
		//then
		assertEquals("1", result);
	}

	@Test
	void testDecToHex_Dec_10_Return_A() {
		//Given
		int dec = 10;
		
		//when
		String result = HW4_ShalevAbadi.dec2Hex(dec);
		
		//then
		assertEquals("A", result);
	}

	@Test
	void testDecToHex_Dec_17_Return_11() {
		//Given
		int dec = 17;
		
		//when
		String result = HW4_ShalevAbadi.dec2Hex(dec);
		
		//then
		assertEquals("11", result);
	}
	
	@Test
	void testDecToHex_Dec_1194684_Return_123ABC() {
		//Given
		int dec = 1194684;
		
		//when
		String result = HW4_ShalevAbadi.dec2Hex(dec);
		
		//then
		assertEquals("123ABC", result);
	}
	
	@Test
	void testSpecialPrint_Str_Empty_Return_Empty() {
		//Given
		String str = "";
		char delimeter = '$';
		//when
		String result = HW4_ShalevAbadi.specialPrint(str, delimeter);
		
		//then
		assertEquals("", result);
	}

	@Test
	void testSpecialPrint_Str_SingleChar_Return_SingleChar() {
		//Given
		String str = "A";
		char delimeter = '$';
		//when
		String result = HW4_ShalevAbadi.specialPrint(str , delimeter);
		
		//then
		assertEquals("A", result);
	}

	@Test
	void testSpecialPrint_Str_DubleChar_Delimeter_Return_DubleCarAndDelimeter() {
		//Given
		String str = "AB";
		char delimeter = '$';
		//when
		String result = HW4_ShalevAbadi.specialPrint(str , delimeter);
		
		//then
		assertEquals("A$B", result);
	}

	@Test
	void testSpecialPrint_Str_Hello_Delimeter_Return_HelloWithDelimeters() {
		//Given
		String str = "Hello";
		char delimeter = '!';
		//when
		String result = HW4_ShalevAbadi.specialPrint(str , delimeter);
		
		//then
		assertEquals("H!e!l!l!o", result);
	}
	
}
	
