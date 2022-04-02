/**
  CART_PRODUCTS 테이블은 장바구니에 담긴 상품 정보를 담은 테이블입니다.
  CART_PRODUCTS 테이블의 구조는 다음과 같으며, ID, CART_ID, NAME, PRICE는 각각 테이블의 아이디, 장바구니의 아이디, 상품 종류, 가격을 나타냅니다.

  NAME	TYPE
  ID	INT
  CART_ID	INT
  NAME	VARCHAR
  PRICE	INT

  COUPONS 테이블은 장바구니에 적용된 쿠폰 정보를 담은 테이블입니다.
  COUPONS 테이블의 구조는 다음과 같으며, ID, CART_ID, MINIMUM_REQUIREMENT, DISCOUNT_AMOUNT는 각각 쿠폰의 아이디, 쿠폰이 적용된 장바구니의 아이디, 최소 주문 금액, 할인 금액을 나타냅니다. 예를 들어, MINIMUM_REQUIREMENT가 50,000인 쿠폰은 (쿠폰 적용 전) 상품 가격 합이 50,000 이상인 장바구니에만 적용할 수 있습니다.

  NAME	TYPE
  ID	INT
  CART_ID	INT
  MINIMUM_REQUIREMENT	INT
  DISCOUNT_AMOUNT	INT

  문제
  장바구니에 들은 상품의 가격 합이 쿠폰의 최소 주문 금액 미만이어도 쿠폰이 적용되는 버그를 발견하였습니다.
  COUPONS 테이블에 주어진 모든 장바구니의 아이디와, 해당 장바구니에 버그가 악용되었는지 조회하는 SQL 문을 작성해주세요. 버그가 악용되었다면 1, 아니라면 0를 표시해주세요.
  또한 결과는 장바구니의 아이디 순으로 나와야 합니다.

  예시
  예를 들어 CART_PRODUCTS 테이블과 COUPONS 테이블이 다음과 같다면

  CART_PRODUCTS 테이블

  ID	CART_ID	NAME	PRICE
  5508	287	Facial Tissue	10900
  5509	287	Dish Detergent	4900
  5510	287	Vegetable	2480
  8434	448	Toilet Paper	19500
  8452	448	Diaper	18900
  8436	448	Laundry Care	12900
  19129	977	Yogurt	2980
  19130	977	Butter	4890
  19131	977	Chicken	6180

  COUPONS 테이블

  ID	CART_ID	MINIMUM_REQUIREMENT	DISCOUNT_AMOUNT
  0	287	100000	9000
  3	977	50000	5000
  5	448	50000	3000

  287번 장바구니에 담긴 상품의 가격 합은 10900 + 4900 + 2480 = 18,280입니다. 장바구니에 적용된 쿠폰의 최소 주문 금액은 100,000이므로 이 장바구니에는 버그가 악용되었습니다.
  448번 장바구니에 담긴 상품의 가격 합은 19500 + 18900 + 12900 = 51,300입니다. 장바구니에 적용된 쿠폰의 최소 주문 금액은 50,000이므로 이 장바구니에는 버그가 악용되지 않았습니다.
  977번 장바구니에 담긴 상품의 가격 합은 2980 + 4890 + 6180 = 14,050입니다. 장바구니에 적용된 쿠폰의 최소 주문 금액은 50,000이므로 이 장바구니에는 버그가 악용되었습니다.
  따라서 SQL 문을 실행하면 다음과 같이 나와야 합니다.

  CART_ID	ABUSED
  287	1
  448	0
  977	1
 */

SELECT c.cart_id, if(r.sum_price < c.minimum_requirement, 1, 0) as ABUSED
from coupons as c
         left join
     (select cp.cart_id, sum(cp.price) as sum_price
      from cart_products as cp
      group by cp.cart_id) as r
     on c.cart_id = r.cart_id
order by c.cart_id ASC;