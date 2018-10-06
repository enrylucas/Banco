package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._

object ItemDao {

  val itens = TableQuery[Item]

  def listaItem()={
    for {
      i <- itens
    } yield i
  }

  def buscaItem(nome : String)= {
    for {
      i <- itens
      if i.nome === nome
    } yield i
  }



}
