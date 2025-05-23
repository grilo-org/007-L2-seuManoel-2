API de Embalagem - Seu Manoel

API que recebe pedidos com produtos e retorna como embalar em caixas otimizadas.


Endpoints

### POST `/api/pedidos`

Recebe pedidos com produtos (dimensões) e retorna as caixas utilizadas.

### Exemplo de entrada

Exemplo de json
[
  {
    "codigoPedido": "001",
    "produtos": [
      { "nome": "Controle", "altura": 10, "largura": 10, "comprimento": 10 },
      { "nome": "Console", "altura": 30, "largura": 30, "comprimento": 20 }
    ]
  }
]

Docker

docker build -t seu-manoel-api .

docker run -p 8080:8080 seu-manoel-api

Stack
Java 17, Spring Boot, Maven, Docker, Swagger
