# language: pt

Funcionalidade: Exportar documentos no formato ZIP

  Contexto:
    - Story 0002 - R01
    Dado que o usuário esteja na tela de documentos

  Cenário: Carregar visualização para escolha do local
    - Story 0002 - R02
    Quando o usuário inicializar o processo para exportar em ZIP
    Então deverá abrir uma janela do sistema operacional utilizado para escolha do local no qual serão exportados os documentos

  Cenário: Listar arquivos indisponíveis
    - Story 0002 - R03
    Dado que existem arquivos indisponíveis, corrompidos ou em formados diferentes do ZIP
    Quando o usuário inicializar o processo para exportar em ZIP
    Então uma mensagem deve ser exibida alertando os documentos que não serão baixados, com as opções para que ele aceite ou não

  Esquema do Cenário: Exportação com arquivos indisponíveis
    - Story 0002 - R04 e R08
    Dado que o usuário tenha inicializado o processo de exportação de arquivos em ZIP com arquivos indisponíveis
    Quando o usuário clicar no <botão>
    Então <resultado>
    Exemplos:
      | botão    | resultado                                                                                                                                              |
      | Aceitar  | O arquivo indisponível não será compactado com os demais, mas será criado um arquivo de texto para cada arquivo indisponível com a crítica encontrada  |
      | Cancelar | A exportação não será realizada e voltará para a tela anterior.                                                                                        |

  Esquema do Cenário: Exportação de arquivos
    - Story 0002 - R05 e R07
    Dado que a árvore de documentos possua <quantidade> arquivo para exportação
    Quando o usuário confirmar o processo de exportação
    Então <resultado>
    Exemplos:
      | quantidade    | resultado                                                                                                    |
      | 1             | O download do arquivo em formato ZIP será realizado.                                                         |
      | mais de 1     | Cada arquivo será compactado em um arquivo diferente e com formato ZIP e será realizado o download de todos  |

  Cenário: Exibir mensagem sobre cancelamento
    - Story 0002 - R06
    Dado que o usuário tenha inicializado o processo para exportar em ZIP
    Quando o usuário aceitar a exportação
    Então o sistema deve exibir uma mensagem informando que o processo não poderá ser cancelado depois de iniciado.