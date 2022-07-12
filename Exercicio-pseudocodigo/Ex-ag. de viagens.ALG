Algoritmo "Agência de viagens"


// Autor(a)    : Ariana dos Santos da Palma
// Data atual  : 11/07/2022
Var
   cliente: vetor[1..4] de caracter
   destino: vetor[1..4] de caracter
   destinoCliente: vetor[1..4] de caracter
   nome, email, end, tel, cpf: vetor[1..4] de caracter
   valor:vetor[1..4] de real
   opcao, opcao2, resp, esc: caracter
   codigo: inteiro
   encontrar: logico

   i, f:inteiro


Inicio
   //declaração dos pacotes-destino
   destino[1] <- "Salvador"
   valor[1]<- 1578
   destino[2] <- "Rio de Janeiro"
   valor[2] <- 1085
   destino[3] <- "São Paulo"
   valor[3] <- 1570
   destino[4] <- "Florianopolis"
   valor[4] <- 1058

   //inicio-Menu
   escreval("  ******************************************************* ")
   escreval("                                                          ")
   escreval("                SEJA BEM VINDO A DVSVIAGEM                ")
   escreval("                                                          ")
   escreval("  ******************************************************* ")
   escreval("                 Deseja fazer um cadastro?                ")
   escreva("")
   escreval("                     Digite sim ou não           ")
   leia(opcao)

   f <- 1

   //cadastrar
   escreval("  ***************** CADASTRO DE CLIENTE ***************** ")
   se (opcao = "sim") então
      para i de 1 ate 4 faca
         se f = "1" entao

            escreva("Nome: ")
            leia(nome[i])
            escreva("CPF: ")
            leia(CPF[i])
            escreva("E-mail: ")
            leia(email[i])
            escreva("Telefone: ")
            leia(tel[i])
            escreva("Endereço: ")
            leia(end[i])
            escreval("")
            escreval("Deseja continuar o cadastro?  ")
            escreval("")
            escreval("Digite (1)sim ou (2)não ")
            leia(f)
         fimse
      fimpara

   senao
      escreval("fim de cadastro.")
   fimse


   //Escolha do pacote de destino
   se (opcao = "sim") então
      escreval(" Escolha um destino")
      escreval (" ")
      escreval ("1 ****", destino[1],"****")
      escreval(" Preço do pacote individual(Hotel + Aéreo):  R$ ", valor[1])
      escreval ("2 ****", destino[2],"****")
      escreval ("  Preço do pacote individual(Hotel + Aéreo):  R$", valor[2])
      escreval ("3 *** ", destino[3]," ***")
      escreval ( " Preço do pacote individual(Hotel + Aéreo):  R$", valor[3])
      escreval ("4 ****", destino[4],"****")
      escreval (" Preço do pacote individual(Hotel + Aéreo):  R$", valor[4])
      leia(codigo)

      codigo <- 1
      codigo <- 2
      codigo <- 3
      codigo <- 4

   fimse

   limpatela

   //consulta
   escreval("  **************************************************** ")                                                              |")
   escreval("                     Deseja consultar?                 ")
   escreval("")
   escreval("                  Digite sim  ou  não                ")
   escreva ("")
   escreval("  **************************************************** ")
   leia(opcao2)


   se (opcao2 = "sim") então
      limpatela
      escreval("  **************** CONSULTA ***************** ")
      escreva("")
      escreval("          Informe seu CPF para consulta ")
      leia(resp)
      escreval("")

      para i de 1 ate 4 faca
         se cpf[i] = resp entao
            escreval ("Nome: ", nome[i])
            escreval ("CPF: ", cpf[i])
            escreval ("E-mail: ", email[i])
            escreval ("Telefone: ", tel[i])
            escreval ("Endereço: ", end[i])
            escreval ("Destino escolhido: ", destino[i])
            escreval ("valor do pacote:  R$", valor[i])
            encontrar := verdadeiro
         fimse
      fimpara

      se encontrar <> verdadeiro então
         escreval("---------Nome informado não encontrado!---------")
      senao
         escreval("")
         escreval(" *** Viaje conosco, Agradecemos a preferência. *** ")
         escreval("")

      fimse
   fimse

Fimalgoritmo