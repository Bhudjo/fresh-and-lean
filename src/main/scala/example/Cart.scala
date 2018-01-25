package example

case class Cart(items: List[String]) {
  val namesToPrices = Map(
    "Bananas" -> 150,
    "Apples" -> 100,
    "Cherries" -> 75)

  def total: Int = {
    items.map(namesToPrices.getOrElse(_, 0)).sum
  }

  def addProduct(productName: String): Cart = {
    Cart(items:+productName)
  }

}

object Cart {
  def empty = Cart(List.empty)
}