package br.edu.unifei.darksouls3
import scala.slick.driver.PostgresDriver.simple._
class Humanoide(tag: Tag) extends Table[(String,String,Int,Int,Int,Long,Boolean,Int,Int,Int,Int,Float,Float,Int,Float,Int,String)](tag,"humanoide"){
  val regioes = TableQuery[Regiao]
  val aparencias = TableQuery[Aparencia]
  val classes = TableQuery[Classe]

  def nome = column[String]("nome",O.PrimaryKey)
  def classeNome = column[String]("classeNome")
  def vida = column[Int]("vida")
  def foco = column[Int]("foco")
  def estamina = column[Int]("estamina")
  def almas = column[Long]("almas")
  def hollow = column[Boolean]("hollow")
  def forca = column[Int]("forca")
  def destreza = column[Int]("destreza")
  def inteligencia = column[Int]("inteligencia")
  def fe = column[Int]("fe")
  def defesaFisica = column[Float]("defesaFisica")
  def defesaMagica = column[Float]("defesaMagica")
  def nivel = column[Int]("nivel")
  def cargaEquipamento = column[Float]("cargaEquipamento")
  def idAparencia = column[Int]("idAparencia")
  def regiaoNome = column[String]("regiaoNome")

  def * = (nome,classeNome,vida,foco,estamina,almas,hollow,forca,destreza,inteligencia,fe,defesaFisica,defesaMagica,nivel,cargaEquipamento,idAparencia,regiaoNome)

  def aparencia = foreignKey("aparencia_FK",idAparencia,aparencias)(_.idVisual)
  def localizacao = foreignKey("regiao_FK",regiaoNome,regioes)(_.nome)
  def classe = foreignKey("classe_FK", classeNome, classes)(_.nome)
}
