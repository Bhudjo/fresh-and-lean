package example

case class Cart(items: Map[String, Int]) {
  val namesToPrices = Map(
    "Bananas" -> 150,
    "Apples" -> 100,
    "Pommes" -> 100,
    "Mele" -> 100,
    "Cherries" -> 75)

  val discounts = Map(
    "Cherries" -> (2, 20),
    "Bananas" -> (2, 150)
  )


  def total: Int = {
    val discount = calculateCartDiscount
    val total = items.map { case (n, q) => namesToPrices.getOrElse(n, 0) * q }.sum
    total - discount
  }

  private def calculateCartDiscount = {
    items.map { case (itemName, quantityInCart) =>
      val (quantityToGetDiscount, discountValue) = discounts.getOrElse(itemName, (0, 0))
      if (quantityInCart >= quantityToGetDiscount) discountValue else 0
    }.sum
  }

  def addProduct(productName: String): Cart = {
    val quantity = items.getOrElse(productName, 0) + 1
    Cart(items ++ Map(productName -> quantity))
  }

}

object Cart {
  def empty = Cart(Map.empty)
}