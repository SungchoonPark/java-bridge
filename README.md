***
## 프로그램 개요
- 다리 생성할때 랜덤으로 위 아래 중 건널 수 있는칸 선택하기
  - 0 -> 아래칸이 건널 수 있음 , 1 -> 위칸이 건널 수 있음
- 다리의 길이는 숫자로 입력받고 생성
  - 3~20 숫자를 입력받아야함.
- 위칸 이동은 대문자 U 아래칸 이동은 대문자 D
- 이동한 칸 건널 수 있다면 O로 표시, 없으면 X로 표시
- 다리 끝까지 건너면 게임 종료
- 실패할시 재시작 또는 종료할 수 있음
  - 재시작해도 처음에 만든 다리 재사용함
  - 게임 시작 포함 끝까지 게임 한 횟수가 총 시도한 횟수임

# 📜 기능 명세서 📜

***

### 입출력
- [x] 다리의 길이 입력받는 기능
- [x] 이동할 칸 입력받는 기능
- [x] 게임을 다시 시도할지 입력받는 기능
- [x] 게임의 진행상황 출력 기능
- [x] 게임 성공여부 및 총 시도횟수 출력 기능

### 주요 기능
- [x] 랜덤하게 다리 건널 수 있는 칸 구해서 다리 생성
- [x] 사용자의 선택(U or D)에 따라 건널 수 있는지 판단
- [x] 게임의 총 시도횟수 관리
- [x] 게임의 성공여부 판단

# ❗️ 예외 상황 ❗

***
### 공통 예외
- [x] **공백 입력** ex) ` `

### 입력시 예외
- [x] 다리의 길이가 [3, 20] 범위가 아닌 경우 ex) 2, 22, 21
- [x] 이동할 칸이 U 또는 D가 아닌 경우 ex) Down, A
- [x] 게임 재시작 여부가 R 또는 Q가 아닌 경우 ex) Retry, Quit, A
