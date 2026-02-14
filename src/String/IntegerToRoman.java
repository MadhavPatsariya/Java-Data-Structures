package String;

import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman roman = new IntegerToRoman();
        System.out.println(roman.intToRoman(1));
    }

    public String intToRoman(int num) {
        List<Integer> decimals = new ArrayList<>();
        int base = 1;
        while(num > 0) {
            int quotient = num % 10;
            num = num / 10;
            quotient = quotient * base;
            base *= 10;
            decimals.add(quotient);
        }
        StringBuilder result = new StringBuilder();
        for(int i = decimals.size() - 1; i >= 0; i--) {
            int current = decimals.get(i);
            if(current >= 1000) {
                int times = current / 1000;
                while(times > 0){
                    result.append(conversionTable(1000));
                    times--;
                }
            }
            else if(current > 500) {
                int times = current / 100;
                if(times == 9) {
                    result.append('C').append('M');
                }
                else {
                    times -= 5;
                    result.append('D');
                    while(times > 0) {
                        result.append(conversionTable(100));
                        times--;
                    }
                }
            }
            else if(current == 500) {
                result.append('D');
            }
            else if(current >= 100) {
                int times = current / 100;
                if(times == 4) {
                    result.append('C').append('D');
                }
                else {
                    while(times > 0) {
                        result.append(conversionTable(100));
                        times--;
                    }
                }
            }
            else if(current > 50) {
                int times = current / 10;
                if(times == 9) {
                    result.append('X').append('C');
                }
                else {
                    times -= 5;
                    result.append('L');
                    while(times > 0) {
                        result.append(conversionTable(10));
                        times--;
                    }
                }
            }
            else if(current == 50) {
                result.append('L');
            }
            else if(current >= 10) {
                int times = current / 10;
                if(times == 4) {
                    result.append('X').append('L');
                }
                else {
                    while(times > 0) {
                        result.append(conversionTable(10));
                        times--;
                    }
                }
            }
            else if(current > 5) {
                int times = current;
                if(times == 9) {
                    result.append('I').append('X');
                }
                else {
                    times -= 5;
                    result.append('V');
                    while(times > 0) {
                        result.append(conversionTable(1));
                        times--;
                    }
                }
            }
            else if(current == 5) {
                result.append('V');
            }
            else if(current >= 1) {
                int times = current;
                if(times == 4) {
                    result.append('I').append('V');
                }
                else {
                    while(times > 0) {
                        result.append(conversionTable(1));
                        times--;
                    }
                }
            }
        }
        return result.toString();
    }

    public char conversionTable(int val) {
        switch(val) {
            case 1000:
                return 'M';
            case 500:
                return 'D';
            case 100:
                return 'C';
            case 50:
                return 'L';
            case 10:
                return 'X';
            case 5:
                return 'V';
            case 1:
                return 'I';
            default:
                return '.';
        }
    }
}
