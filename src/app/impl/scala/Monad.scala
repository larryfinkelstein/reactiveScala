package app.impl.scala


class Monad {

  //Sealed specify that this trait can only be extended in this file
  sealed trait Maybe[+A] {
    // >>=
    def flatMap[B](f: A => Maybe[B]): Maybe[B]
  }

  case class Just[+A](a: A) extends Maybe[A] {
    override def flatMap[B](f: A => Maybe[B]) = f(a)
  }

  // Nothing in the Haskel example
  case object MaybeNot extends Maybe[Nothing] {
    override def flatMap[B](f: Nothing => Maybe[B]) = MaybeNot
  }

}
