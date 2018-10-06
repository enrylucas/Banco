package br.edu.unifei.darksouls3.dao

import br.edu.unifei.darksouls3.models.{Humanoide, Item, Pacto, PactoHumanoide}


import scala.slick.driver.PostgresDriver.simple._

object HumanoideDao {

  val humanoides = TableQuery[Humanoide]
  val itens = TableQuery[Item]
  val pactos = TableQuery[Pacto]
  val pactohumanoide = TableQuery[PactoHumanoide]

  def listaHumanoide()={
    for {
      h <- humanoides
    } yield h
  }

  def buscaHumanoide(nome : String)= {
    for {
      h <- humanoides
      if h.nome === nome
    } yield h
  }

  def listaInventario(nome : String)= {
    for {
      (h,i) <- humanoides join itens on (_.nome === _.humanoideNome)
      if h.nome === nome
    } yield i
  }

  def listaPactos(nome : String)={
    for{
      ((h,ph),p) <- humanoides leftJoin pactohumanoide on(_.nome === _.humanoideNome) leftJoin pactos on (_._2.pactoNome === _.nome)
      if h.nome === nome
    } yield p
  }

}