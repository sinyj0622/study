
191209
//리터럴 (literal) : 데이터 표현법

 1. 정수 리터럴
 정수를 저장할 메모리의 크기를 지정할수있다
 메모리의 크기에 따라 표현할수 있는 정수의 크기가 다르다

 - 10진수 리터럴 : 코드에서 일반적으로 정수 값을 표현할때 사용한다
 - 8진수 리터럴 : 코드를 작성할때 잘 사용하지 않는다,
  0으로 시작해야한다
 - 2진수 리터럴 : 0b 또는 0B 로 시작한다, 메모리의 상태를 직설적으로 보여주고 싶을때 사용한다, 
 - 16진수 리터럴 : 0x 또는 0X 로 시작한다, 2진수를 간결하게 표현하기 위해 사용한다


-- 정수리터럴 메모리 크기에 따른 표기법
 ***정수 리터럴은 4바이트가 기본, 8바이트는 정수리터럴 L,l을 붙여야한다
 >메모dfjk리의 크기가 다름!! 메모리의 크기를 지정할수있다
    ex) 다음은 크기가 다른 정수이다.
        system.out.println(100)
        system.out.println(100L)  

정수를 메모리에 저장하는 방법(2의 보수로 저장)
자바에서 음수를 저장하는 방법, 컴퓨터는 2의 보수로 계산한다

-- 정수를 2진수로 표현하는 방법
1) 절대값 sign-magnitude
: 맨 앞 비트로 음수표시 (1이면 -, 0이면 +)
두 개의 +0, -0이 존재한다
양수와 음수를 더했을때 옳지 않은 값이 나온다

2) 1의 보수
: 모든 비트를 1이 되는 수로 바꾼다 즉 0을 1로, 1을 0으로 바꾼다

3) 2의 보수
: 자바에서 음수를 저장하는 방법
: 1의 보수의 번거로움을 없애기위해 음수를 저장할때 미리 1을 추가해 두는 방법
1의 보수의 문제점을 해결하기 위해 등장한 방법
음수 0을 없앰으로써 -128까지 표현할 수 있음
 - 2의 보수를 만드는방법
 오른쪽에서부터 1을 찾는다
 찾은 1의 왼쪽편에 있는 모든 비트를 반대 값으로 바꾼다
 ex) 0010 1100(44) => 1101 0100(-44)
  장점 :  양수와 음수의 덧셈이 가능하다
        음수 0이 없다. 0에 대한 표현이 한가지이다
4) k-초과 excess-k


 2. 부동 소수점 리터럴
: 소수점의 위치를 움직인다고 해서 부동소수점, exponential 익스포낸셜이다
e 기호를 사용하면 소수점의 위치를 조정할수있다

-- 부동소수점 메모리 크기에 따른 표기법
***부동 소수점 리터럴은 8바이트가 기본(D), 4바이트는 f,F가 붙는다
 >메모리의 크기가 다름!! 메모리의 크기를 지정할수있다
      System.out.println(3.14D); //double
      System.out.println(3.14f); //float

- 부동 소수점 최대값과 최소값(유효자릿수)
정수처럼 메모리 크기(4바이트,8바이트)에 따라 표현할수 있는 부동소수점의 범위가 다르다. 유효자릿수라는 방식으로 대략적으로 값의 범위를 표현한다
  4바이트(float) 부동소수점의 유효자릿수 - 7자리
  8바이트(double) 부동소수점의 유효자릿수 - 15자리
**IEEE-754 규격에 따라 부동소수점을 2진수로 바꿔도 정확하게
저장되지 않는다 => 시스템에서 필요한 만큼 소수점 이하 자리수를
적절히 짤라 사용하라!!
- 부동 소수점을 2진수로 변환하는것을 '정규화' 라고한다
  이런 정규화 규칙을 정의한 문서가 IEEE-754이다
- 부동 소수점의 리터럴은 왜 8바이트인가?
(정수는 4바이트 기본)
 : 작은 부동소수점인 경우도 유효자릿수를 쉽게 넘어가기 때문에 자바는 기본으로 8바이트 메모리를 사용한다


 3. 문자 리터럴
 : 자바는 문자를 다룰때 2바이트 값으로 다룬다
 각 문자를 표현하기 위해 정의된값을 'character code'
 각 문자에 부여된 문자코드의 집합을 'character set'
 자바가 사용하는 문자 집합은 Unicode 이다. 


 1) ASCII 7bit
 2) ISO-8859-1 (ISO-Latin-1) 8bit
 3) EUC-KR
 4) 조합형 (표준x)
 5) MS-949 (표준x)
 6) Unicode (UCS-2) = utf-16
  국제 표준 규격 영어,한글 2byte
 7) UTP-8
  영어는 그대로 1byte(8bit) 그 외 문자는 2~4byte, 한글은 3byte



 -- Unicode 유니코드 //JVM 에서 사용됨
 자바는 메모리에 문자를 저장할때는 UCS 를 사용하고, 외부로 입출력 할때는 UTF를 사용한다
 UCS-2 : 영어,한글 모두 2Byte(16bit) //JVM 에서 사용됨
 universal character set

 -- UTF-8 //file,network 에서 사용
 영어는 그대로 1Byte 사용, 그 외 문자는 2~4byte 사용한다


 '문자' 단독으로 사용될 떄는 문자로 취급하지만
 다른 값과 연산을 수행하면 해당 문자코드는 그냥 정수로 간주한다
 System.out,println('가' == 44032);
 (char)숫자 앞에 문자 코드임을 알리는 표시를 하라 


 4. 논리 리터럴 (noolean)
-- 논리(boolean)값을 다룰때 메모리 크기?
 JVM은 논리값을 저정할때 4바이트 정수 메모리를 사용한다
 배열인 경우 1바이트 정수 배열의 메모리를 사용한다

  자바는 대소문자를 구분하여 처리한다
  보통 비교연산의 결과로 논리값이 리턴된다
 system.out.println(true);
 system.out.println(false);
  논리 연산의 결과도 논리값이다
 && and || or
 system.our.println(true && true);
 system.out.println(true || false);

5. 이스케이프 문자 (excape character)
 : 문자를 제어하는 기능을 가진 문자
  \n : 줄바꿈 명령
  \r : 커서를 처음으로 돌리는 문자
  \b : 커서를 뒤로 한칸 이동시키는 문자
  \f : form feed 추가시키는 문자
  




191210
// 자바 애플리케이션 프로젝트 만들기
1. 로컬 git 저장소에 자바 프로젝트 폴더를 생성한다
 $ mkdir [프로젝트 이름]
2. 프로젝트 폴더를 자바 앱 프로젝트로 초기화 시킨다
***src 폴더 만드는법*** > $ gradle init
3. 설치된 build.gradle 파일에 다음 설정을 추가한다

```
tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
    sourceCompatibility = '1.8'
    targetCompatibility = '1.8'
}
```
4. 프로젝트를 빌드하라 
 ***build 폴더 만드는법***
 $ gradle build 
 $ gradle compileJava  <distribution 폴더가 안만들어짐

 5.프로젝트를 실행하라
  $ gradle run

// '이클립스 IDE'로 프로젝트 다루기
1. build.gradle 파일에 eclipse 플러그인을 추가한다

```
plugins {
    id 'java'
    id 'application'
    id 'eclipse'   <추가!
}
```

2. 이클립스 IDE에서 사용할 프로젝트 설정 파일을 생성하라
 $ gradle eclipse
3. 이클립스 워크스페이스로 프로젝트를 가져와라
  이클립스 file > import
4. 이클립스 메뉴를 통해 App 클래스를 실행한다


191211
// interface 
서로 대화를 나누기 위한 사용규칙!!!!

//변수 (variables)
온풍기.기능명(기능을 수행하는데 필요한값) <메소드
객체(온풍기).기능하라!
-변수선언 : 데이터/값를 저장할 메모리를 준비시키는 명령
ex) int i; //4바이트 정수 메모리를 준비하고 그 메모리의 이름을 i 라고 하자!
항상 변수가 선언된 다음에 사용해야 한다.
 // (8개 값) 변수를 제외하곤 다 메모리의 주소다!


- 변수 초기화 문장
:변수선언 + 값저장을 한번에 하는것
 ex) int age = 20;    <age에 20을 저장하라!

-할당연산자 '='
: 변수에 값을 넣는 일을 한다
 l-value = r-value
  l-value : 변수가 와야한다, 값이 올수없다
  r-value : 값이나 표현식이 올수있다

  문장 : 자바 언어로 작성한 명령어
  표현식 : 문장중에 값을 리턴하는 문장(값이 놓임)


** println() 메서드(도구)
    //- 콘솔(console)로 '값'을 출력할 때 사용하는 도구이다.
    //- 즉 JVM의 표준 출력 장치로 값을 출력한다.
    //- 사용법
    //    System.out.println(리터럴 또는 변수, 결과가 생성되는 명령문)

    System.out.println(i); 
    // **println() 에 i 변수를 전달하는것이 아니라
    // i 변수에 들어있는 값을 전달하는 것이다. 리턴값(출력값)


reference : 다른 메모리의 주소를 저장하는 변수
String : 문자열을 저장하는 메모리
Date : 날짜를 저장하는 메모리
java.sql.Date;
java.net.Socket;


// 큰 메모리의 값을 작은 메모리에 저장하려할때 컴파일 오류!!!

 //4바이트 정수 리터럴 ==> byte, short 변수
    //- 4바이트 리터럴인 경우 메모리 크기에 상관없이 저장할 수만 있다면 
    //  byte(1바이트), short(2바이트) 메모리에 값을 저장해도 컴파일 오류가 발생하지 않는다. 
    //    
    byte b;
    short s;
    
    b = 127;   // 4바이트 리터럴(127정수) ==> 1바이트 메모리
    s = 32767; // 4바이트 리터럴(32767) ==> 2바이트 메모리

    


191212

- 문자변수
char c = 'A' 
// c 변수에 저장되는것은 문자 'A'의 UCS-2 문자코드이다.
// 문자 코드 값을 모른다면 따옴표를 사용하라!
// - 문법
//  '문자' : UCS-2에 정의된 코드 값을 리턴한다.

- System.out.println();
: 시스템이라는 상자에 out이라는 도구의 기능중 하나


**8개의 변수를 제외하곤 다 메모리의 주소다!**

// System.out
// - 표준 출력 장치.
// - 즉 콘솔(모니터, 명령창)을 가리킨다.
// System.in
// - 표준 입력 장치.
// - 즉 키보드를 가리킨다.


191213

int[] arr1 = new int[3];
arr1[0] = 100;
arr1[0] = 30;
arr1[0] = 90;

int[] arr2 = new int[]{100,30,90};


// [정리]
// 레퍼런스(reference)란? 배열의 주소
// - 값이 아닌 메모리의 주소를 담는 변수
//
// 인스턴스(instance)란? 
// - 값을 저장하는 메모리.


일반 변수는 값을 저장하지 않고 사용할 수 없다.
    // 일반 변수와 달리 new 명령으로 확보된 메모리는 종류에 상관없이 기본 값으로 자동 초기화 된다.
    // 따라서 배열 메모리 또한 생성되는 순간 기본 값으로 자동 초기화 된다.
    // - 정수 배열(byte[], short[], int[], long[]) : 0
    // - 부동소수점 배열(float[], double[]) : 0.0
    // - 논리 배열(boolean[]) : false 
    // - 문자 배열(char[]) : '\u0000'
    // - 주소 변수(Object[]) : null

    nextInt(); white space를 만나면 그 전까지 리턴한다
    다음 메서드는 공백으로 리턴한다

    nextLine(); scanner 도구를 사용하여 키보드로부터
    한줄의 '문자열'을 가져올때 사용하는 명령
    사용자가 한줄 입력할때까지, 즉 입력데이터에 줄바꿈을
    의미하는 엔터가 들어올때까지 대기한다
    enter 키를 누르면 입력값을 리턴한다


    next(); 한개의 token(단어)를 읽는다
    공백을 만날때까지 읽는다
    물론 nextInt()와 다르게 읽은 후 공백을 제거

    for문 인덱스 몇번~몇번까지 반복하라..
    메모리를 제어하는 문법..
  


191216

상수
: 한번 저장된 값을 변경하지 못하게 하는 문법 final
변수의 값을 고정하는 방법
final int b;
b = 100;
b = 200; 컴파일오류

변수와 상수를 구분하기 위해서
> 상수인 경우 이름을 보통 모두 대문자로 작성한다
> 그리고 변수를 선언하는 문자에서 바로 값을 초기화시킨다


// 형변환
1) 정수 변수 > 부동소수점 변수
: 유효자릿수를 넘어가는 정수 값인 경우 부동소수점 메모리에 저장될때 잘릴수있다 그럼에도 컴파일 오류가 발생하지 않기 때문에 놓치는 경우가 많다

2) 부동소수점 변수 > 정수 변수
: 부동소수점 메모리의 값을 정수 메모리에 저장할수없다
왜? 정수메모리는 소수점 이하의 값을 저장할수 없기 때문에 자바에서는 부동소수점 값을 정수 메모리에 저장하는것을 문법에서 막는다

// 명시적 형변환
    // 부동소수점 메모리의 값을 정수 메모리에 저장할 때
    // 값이 짤릴 수 있음을 알면서도 정수 메모리에 저장해야 할 때가 있다.
    // 또는 큰 메모리의 값을 작은 메모리에 저장해야 할 때가 있다.
    //
    // 해결책?
    // - 컴파일러에게 강제로 값을 넣을 것을 명시하라!
    // - 이것을 "명시적 형변환(explicit type conversion)"이라 부른다.


//정수 메모리끼리 형변환가능
    // 정수를 부동소수점 메모리에 저장가능. 명시적 형변환 필요없음
    // 숫자를 문자 변수에 저장가능
    i = 65;
    char c = (char) i;
    System.out.println(c);


코드를 작성할 때 피연산자의 계산 결과가 피연산자의 메모리 크기를
//   벗어날 가능성이 있다면,
//   처음부터 피연산자의 값을 더 큰 메모리에 담아서 연산을 수행하라!
//   


// 형변환(type casting=type conversion)?
// - 변수나 리터럴을 다른 타입의 값을 바꾸는 것이다.
// - 주의!
//   원래 변수의 타입을 바꾸는 것이 아니다.
//   내부적으로는 변수에 들어 있는 값을 꺼내 
//   지정된 타입의 임시 메모리를 만들어 저장한다.
//
// 결론!
// 1) 자바의 최소 연산 단위는 int이다.
//    따라서 int 보다 작은 크기의 메모리 값을 다룰 때는
//    내부적으로 int로 자동 형변환을 수행한 다음에 연산을 수행한다.
//    내부적으로 자동 형변환하는 것을 
//    "암시적 형변환(implicit type conversion)"이라 부른다.
// => byte + byte = int
// => short + short = int
// => byte + short = int
// 
// 2) 연산 결과는 항상 피연산자의 타입과 같다.
// => int + int = int
// => long + long = long
// => float + float = float
// => double + double = double
//
// 3) 다른 타입과 연산을 수행할 때는 
//    내부적으로 같은 타입으로 맞춘 다음에 실행한다.
//    Exam01_5.java를 보라!

    // boolean + int = 컴파일 오류!
    // => 산술 연산자는 정수 타입(byte, short, char, int, long)과
    //    부동소수점 타입(float, double)에 대해서만 
    //    실행할 수 있다. 


  산술 연산자 + - * / %(나머지값
  관계 연산자 < <= > >= == !=
         // ****비교의 결과는 true 또는 false이다.***
        // ****즉 boolean 값이다.****

        int a = 100;
        int b = 200;
        boolean b = a > b;


  관계 연산자 :  부동소수점 비교
  // - 부동소수점 값을 연산할 때 IEEE 754 명세에 따라 
        //   작업을 수행한다. 그 과정에 값의 왜곡이 발생할 수 있다.
        // - CPU나 OS, JVM의 문제가 아니다.
        // - IEEE 754 명세에 따라 부동소수점을 처리하는 모든 
        //   컴퓨터에서 발생하는 문제이다.

  논리 연산자 && || !(not), ^(XOR; exclusive-OR)

        // AND 연산자 &&
        // - '두 개의 논리 값이 모두 true'일 때 결과가 true가 된다.
        // OR 연산자 ||
        // - '두 개의 논리 값 중 한 개라도 true'이면 결과는 true가 된다.

        // NOT 연산자  !
        // - true는 false로 false는 true로 바꾼다.
        System.out.println(!true);
        System.out.println(!false);

        // exclusive-OR(XOR)연산자 
        // - 배타적 비교 연산자라 부른다.
        // - 두 개의 값이 다를 때 true이다.
        System.out.println(true ^ true);
        System.out.println(false ^ false);
        System.out.println(true ^ false);

// &&, ||
// - "앞의 피연산자의 값으로 결과를 알 수 있다면 뒤의 명령은 실행하지 않는다."
// - jvm은 실행의 효율을 위해 &&연산의 오른쪽을 실행하지 않는다
// 
// &, |
// - "앞의 피연산자로 결과를 알 수 있을 지라도, 
//   뒤에 놓은 명령까지 모두 실행한다."
// & 연산자의 경우 왼쪽값으로 결과를 예측할수 있다 하더라고
// 결과에 상관없이 & 오른쪽 문장을 무조건 실행한다





