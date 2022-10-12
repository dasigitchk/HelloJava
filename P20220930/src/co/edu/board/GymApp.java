//package co.edu.board;
//
//import java.util.Scanner;
//
//
//public class GymApp {
//	public static void main(String[] args) {
//
//				// 메뉴: 1.회원등록 2.회원정보수정 3.회원정보조회 4:종료
//				Members[] member = new Members[10];
//				Scanner scn = new Scanner(System.in);
//				outerLoop: while (true) {
//					System.out.println("0.회원등록, 1.회원정보수정 2.회원정보조회, 9.종료");
//					int menu = scn.nextInt();
//					scn.nextLine(); // 
//					invalid[] banks;
//					Loop1: if (menu == 1) {
//						// 예금기능. 어떤계좌번호에 얼마를?
//						System.out.println("이름을 입력하세요 : ");
//						String name = scn.nextLine();
//						Object accNo;
//						for (int i = 0; i < member.length; i++) {
//							if (banks[i] != null && !accNo.equals(banks[i].accNo)) {
//								System.out.println("없는 계좌번호입니다.");
//								break Loop1;
//							}
//						}
//						System.out.println("예금할 금액을 입력하세요 : ");
//						int Money = scn.nextInt();
//
//						for (int i = 0; i < banks.length; i++) {
//							if (banks[i] != null && banks[i].accNo.equals(accNo)) {
//								banks[i].balance = banks[i].balance + Money;
//							}
//						}
//					} else if (menu == 2) {
//						System.out.println("조회할 계좌번호 입력 >>>");
//						String accNo = scn.nextLine();
//						for (int i = 0; i < banks.length; i++) {
//							if (banks[i] != null && !accNo.equals(banks[i].accNo)) {
//								System.out.println("없는 계좌번호입니다.");
//								break Loop1;
//							}
//						}
//						System.out.println("출금할 금액을 입력하세요 : ");
//						int Money = scn.nextInt();
//						for (int i = 0; i < banks.length; i++) {
//							if (banks[i] != null && banks[i].accNo.equals(accNo)) {
//								if (Money > banks[i].balance) {
//									System.out.println("잔고보다 큰 금액은 출금할수 없습니다.");
//									break;
//								}
//								banks[i].balance = banks[i].balance - Money;
//							}
//						}
//
//					} else if (menu == 3) {
//						System.out.println("조회할 계좌번호 입력 >>>");
//						String accNo = scn.nextLine();
//						for (int i = 0; i < accNo.length(); i++) {
//							if (banks[i] != null && accNo.equals(banks[i].accNo)) {
//								System.out.println("잔액: " + banks[i].balance);
//								break;
//							} else {
//								System.out.println("없는 계좌번호입니다.");
//								break;
//							}
//						}
//					} else if (menu == 4) {
//
//					} else if (menu == 0) {
//						System.out.println("계좌번호 입력 >>> ");
//						String accNo = scn.nextLine();
//						System.out.println("예금주 >>>");
//						String owner = scn.nextLine();
//
//////						Account acc = new Account(); // 인스턴스 생성.
////						acc.accNo = accNo;
////						acc.owner = owner;
//						// 계좌번호 생성
//						for (int i = 0; i < banks.length; i++) {
//
//							if (banks[i] == null) {
//								// 한건입력. break;
////								banks[i] = acc;
//								break;
//							}
//						}
//						System.out.println("계좌생성완료.");
//					}
//				}
//			}
//		}
