package example

case class Cart(items: Map[String,Int]) {
  val namesToPrices = Map(
    "Bananas" -> 150,
    "Apples" -> 100,
    "Cherries" -> 75)

  def total: Int = {
    items.map{case (n,q) => namesToPrices.getOrElse(n, 0)*q}.sum
  }

  def addProduct(productName: String): Cart = {
    val quantity = items.getOrElse(productName, 0)+1
    Cart(items++Map(productName->quantity))
  }

}

object Cart {
  def empty = Cart(Map.empty)
}