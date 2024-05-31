/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 1
*/

public class Lab1A {

    public static void main(String[] args) {
        //create 2d array
        char forwardCar[][];
        forwardCar = new char[4][13];
        //call makeforward method to created array
        forwardCar = makeForward();
        //print out array with for loops
        for(int i = 0; i<4; i++){
            for(int j = 0; j < 13; j++){
                System.out.print(forwardCar[i][j]);
            }
            System.out.println();
        }
        //create second array for makeMirror
        char mirrorCar[][];
        //call makeMirror passing forward array and mirroring art
        mirrorCar = makeMirror(forwardCar);
        //print out mirrored array with for loops
        for(int i = 0; i<4; i++){
            for(int j = 0; j < 13; j++){
                System.out.print(mirrorCar[i][j]);
            }
            System.out.println();
        }
        //print out forward and mirrored to make collison
        for(int i = 0; i<4; i++){
            for(int j = 0; j < 13; j++){
                System.out.print(forwardCar[i][j]);
            }
            for(int j = 0; j < 13; j++){
                System.out.print(mirrorCar[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] makeForward() {
        char[][] pixel = new char[4][13]; pixel[0][0]=' ';
        pixel[0][1]=' ';
        pixel[0][2]='_';
        pixel[0][3]='_'; pixel[0][4]='_'; pixel[0][5]='_'; pixel[0][6]='_'; pixel[0][7]='_'; pixel[0][8]=' '; pixel[0][9]=' '; pixel[0][10]=' '; pixel[0][11]=' '; pixel[0][12]=' '; pixel[1][0]=' '; pixel[1][1]='/'; pixel[1][2]='|'; pixel[1][3]='_'; pixel[1][4]='|'; pixel[1][5]='|'; pixel[1][6]='_'; pixel[1][7]='\\'; pixel[1][8]='\''; pixel[1][9]='.'; pixel[1][10]='_'; pixel[1][11]='_'; pixel[1][12]=' '; pixel[2][0]='('; pixel[2][1]=' '; pixel[2][2]=' '; pixel[2][3]=' '; pixel[2][4]='_'; pixel[2][5]=' '; pixel[2][6]=' '; pixel[2][7]=' '; pixel[2][8]=' '; pixel[2][9]='_'; pixel[2][10]=' '; pixel[2][11]='_'; pixel[2][12]='\\'; pixel[3][0]='='; pixel[3][1]='\''; pixel[3][2]='-'; pixel[3][3]='('; pixel[3][4]='_'; pixel[3][5]=')'; pixel[3][6]='-'; pixel[3][7]='-'; pixel[3][8]='('; pixel[3][9]='_'; pixel[3][10]=')'; pixel[3][11]='-'; pixel[3][12]='\'';
        return pixel;
    }

    public static char[][] makeMirror(char[][] forward){
        char mirror[][];
        mirror = new char[4][13];
        for(int i = 0; i<4; i++){
            int l = 0;
            for(int j = 12; j > -1; j--) {
                if(forward[i][j] == '('){
                    mirror[i][l] = ')';
                } else if(forward[i][j] == ')'){
                    mirror[i][l] = '(';
                }else if(forward[i][j] == '\\'){
                    mirror[i][l] = '/';
                }else if(forward[i][j] == '/'){
                    mirror[i][l] = '\\';
                } else{
                    mirror[i][l] = forward[i][j];
                }
                l++;
            }
        }
        return mirror;
    }

}
