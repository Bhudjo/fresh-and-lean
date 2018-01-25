package example

import org.scalatest._

class CartSpec extends WordSpec with Matchers {
  "the cart" should {
    "give total" in {
      val cart = Cart.empty
      cart.addProduct("Bananas").total shouldEqual 150
    }
    "acceptance test iteration three-a" in {
      Cart.empty
        .addProduct("Cherries")
        .addProduct("Cherries")
        .addProduct("Bananas")
        .addProduct("Bananas")
        .total shouldEqual 270
    }
  }
}
