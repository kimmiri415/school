<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width: 1000px; margin: 0 auto;">
	<div>
		<h3>배열 출력하기</h3>
		<button onclick="opr.sysout()">배열 출력</button>

		<button onclick="opr.score()">어벤져스배열 출력</button>
		<button onclick="opr.grade()">성적 출력</button>
		<button onclick="opr.gender()">성별 출력</button>
		<button onclick="opr.bigNum()">Max 값 출력</button>
		<button onclick="opr.gugudan()">gugudan 출력</button>
		<button onclick="opr.sum1to100()">sum1to100 출력</button>
	</div>

</div>
<script type="text/javascript">
	var opr = {
		sysout : function() {
			var arr = [ '사과', '배', '감', '귤' ];
			for ( var i in arr) {
				console.log(arr[i] + '\t');
			}

		},

		score : function() {
			var result = '';
			var avengers = [];
			avengers.push({
				name : '아이언맨',
				kor : 90,
				eng : 90,
				math : 90
			});
			avengers.push({
				name : '헐크',
				kor : 80,
				eng : 80,
				math : 80
			});
			avengers.push({
				name : '캡틴아메리카',
				kor : 70,
				eng : 70,
				math : 70
			});
			for ( var i in avengers) {
				avengers[i].getSum = function() {
					return this.kor + this.eng + this.math;
				}
				avengers[i].getAvg = function() {
					return this.getSum() / 3;
				}
				console.log(avengers[i].name + '님의 성적 합계 : '
						+ avengers[i].getSum() + '  평균 :'
						+ avengers[i].getAvg());

			}
			result = '=========== 어벤져스 성적표 =============\n';
			result += '이름\t국어\t영어\t수학\t총점\t평균\n';
			result += '-----------------------------------\n';
			for ( var i in avengers) {
				{
					with (avengers[i]) {
						result += name + ':\t' + kor + '\t' + eng + '\t' + math
								+ '\t' + getSum() + '\t' + getAvg() + '\n';
					}
				}
			}
			/*
			with 키워드는 배열에 담긴 하나의 객체를 의미한다.
			즉 예를 들어
			var iron = {name : '아이언맨', kor : 90, eng : 90, math : 90}
			이렇게 선언된 하나의 객체를 avengers.push(iron)이라고 줄 경우
			출력문에서 with를 사용하지 않는다면 iron.name이런 식으로 일일히
			명시해야 하기 때문에 with를 사용한다.
			 */

			console.log(result);
		},

		grade : function() {
			/*
			평균 90이상 A
			80이상 B
			70이상 C
			60이상 D
			미만 F
			 */
			var result = '';
			var kor = 80, eng = 70, math = 60;
			var avg = (kor + eng + math) / 3;
			if (avg >= 90) {
				result = 'A';
			} else if (avg >= 80) {
				result = 'B';
			} else if (avg >= 70) {
				result = 'C';
			} else if (avg >= 60) {
				result = 'D'
			} else {
				result = 'F';
			}
			console.log('학점은 : ' + result);
		},

		gender : function() {
			/*
			800101 - 1234567 일 경우 flag 값은 1이다 라고 정의함
			 */
			var result = '';
			var flag = 4;//라면 성별을 판별하는 로직을 switch -case로 완성하시오
			switch (flag) {
			case 1:
			case 3:
				result = '남자'
				break;
			case 2:
			case 4:
				result = '여자'
				break;
			case 5:
			case 6:
				result = '외국인'
				break;
			default:
				result = '잘못된 값';
				break;
			}

			console.log(result);
		},

		bigNum : function() {
			/*80, 70, 60일 경우 if문으로 최대값을 구하는 로직을 완성하시오*/
			var arr = [ '80', '70', '60' ];
			var max = arr[0];
			if (max < arr[1]) {
				max = arr[1];
			} else if (max < arr[2]) {
				max = arr[2];
			}

			console.log(max);
		},
		gugudan : function() {
			var result = '';
			var i = 1, j = 7;
			for (var int = i; i < 10; i++) {
				//7단 구구단을 출력하시오
				result += j + '+' + i + '=' + (j * i) + '\n';
			}
			console.log(result);
		},

		sum1to100 : function() {
			var sum = 0, i = 1;
			while (i <= 100) {
				/*1부터 100까지의 합을 출력하시오*/

				sum += i;
				i++;
			}
			console.log('1부터 100까지의 합 : ' + sum);
		}

	}
</script>






