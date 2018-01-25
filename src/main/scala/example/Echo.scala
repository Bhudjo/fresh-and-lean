package example

object Echo extends App {
  private val lines: Iterator[String] = io.Source.stdin.getLines
  for (ln <- lines) println(ln)
}

