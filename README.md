# API seu Manoel das caixas.

API que recebe pedidos com produtos e retorna a melhor forma de embalar em caixas otimizadas com base em suas dimensões.

---

## Endpoints

### POST `/api/pedidos`

Recebe pedidos com uma lista de produtos contendo dimensões (altura, largura, comprimento) e retorna as caixas utilizadas para empacotar.

## Docker

**Build da imagem**

docker build -t seu-manoel-api .

**Executar o container**

docker run -p 8080:8080 seu-manoel-api

Acesse a documentação Swagger em:
http://localhost:8080/swagger-ui.html

Stack utilizada
Java 17
Spring Boot
Maven
Swagger (OpenAPI)
Docker

#### ✅ Exemplo de requisição

```json
[
  {
    "codigoPedido": "001",
    "produtos": [
      { "nome": "Controle", "altura": 10, "largura": 10, "comprimento": 10 },
      { "nome": "Console", "altura": 30, "largura": 30, "comprimento": 20 }
    ]
  }
]


