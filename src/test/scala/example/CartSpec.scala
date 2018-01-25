package example

import org.scalatest._

class CartSpec extends WordSpec with Matchers {
  "the cart" should {
    "give total" in {
      val cart = Cart.empty
      cart.addProduct("Bananas").total shouldEqual 150
    }
    "acceptance test iteration five" in {
      Cart.empty
        .addProduct("Mele")
        .addProduct("Pommes")
        .addProduct("Pommes")
        .addProduct("Apples")
        .addProduct("Pommes")
        .addProduct("Mele")
        .addProduct("Cherries")
        .addProduct("Cherries")
        .total shouldEqual 580
    }
  }
}
