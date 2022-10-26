# language: pt

  Funcionalidade: Exportar documentos no formato PDF

    Contexto:
      - Story 0001 - R01
      Dado que o usuário esteja na tela de documentos

      Cenário: Carregar visualização para escolha do local
        - Story 0001 - R02
        Quando o usuário inicializar o processo para exportar em PDF
        Então deverá abrir uma janela do sistema operacional utilizado para escolha do local no qual serão exportados os documentos

      Cenário: Listar arquivos indisponíveis
        - Story 0001 - R03
        Dado que existem arquivos indisponíveis, corrompidos ou em formados diferentes do PDF
        Quando o usuário inicializar o processo para exportar em PDF
        Então uma mensagem deve ser exibida alertando os documentos que não serão baixados, com as opções para que ele aceite ou não

      Esquema do Cenário: Exportação com arquivos indisponíveis
        - Story 0001 - R04
        Dado que o usuário tenha inicializado o processo de exportação de arquivos em PDF com arquivos indisponíveis
        Quando o usuário clicar no <botão>
        Então <resultado>
        Exemplos:
        | botão    | resultado                                                                                                                                                            |
        | Aceitar  | O download será realizado sem os arquivos indisponíveis, mas será acrescido no início do arquivo baixado um resumo das críticas encontradas na árvore de documentos. |
        | Cancelar | A exportação não será realizada e voltará para a tela anterior.                                                                                                      |

      Esquema do Cenário: Exportação de arquivos
        - Story 0001 - R05 e R07
        Dado que a árvore de documentos possua <quantidade> arquivo para exportação
        Quando o usuário inicializar o processo de exportação
        Então <resultado>
        Exemplos:
        | quantidade    | resultado                                                                                        |
        | 1             | O download do arquivo em formato PDF será realizado.                                             |
        | mais de 1     | Os arquivos serão unificados em um único documento com formato PDF e o download será realizado.  |

      Cenário: Exibir mensagem sobre cancelamento
        - Story 0001 - R06
        Dado que o usuário tenha inicializado o processo para exportar em PDF
        Quando o usuário aceitar a exportação
        Então o sistema deve exibir uma mensagem informando que o processo não poderá ser cancelado depois de iniciado.