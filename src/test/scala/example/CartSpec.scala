package example

import org.scalatest._

class CartSpec extends WordSpec with Matchers {
  "the cart" should {
    "give total" in {
      val cart = Cart.empty
      cart.addProduct("Bananas").total shouldEqual 150
    }
    "acceptance test iteration one" in {
      Cart.empty
        .addProduct("Apples")
        .addProduct("Cherries")
        .addProduct("Cherries")
        .total shouldEqual 250
    }
  }
}
