# Notes 📝

Essa aplicação é perfeita para você gerenciar suas notas, podendo criar, atualizar, ver e excluir elas quando quiser!

<br>

# Tecnologias Utilizadas 💻

<ul>
  <li>spring-boot</li>
  <li>mysql</li>
  <li>docker</li>
</ul>

<br>

# Inicializando aplicação e o docker 🐳

Primeiro, caso tenha o mysql instalado em sua máquina e sua porta padrão de inicialização seja a 3306, você terá que parar o serviço padrão do mysql temporariamente, para isso execute o seguinte comando e insira sua senha:

```
service mysql stop

```

Com a porta 3306 disponível podemos subir o container do mysql com docker-compose (atenção aplique esse comando na raiz do projeto):

```
docker-compose up -d

```

Feito isso, basta subir o spring-boot (aplique na raiz do projeto):

```
mvn spring-boot:run

```

Pronto, a aplicação está no ar! experimente suas funcionalidades através de um client!

Após experimentar a aplicação, caso queira subir o serviço padrão do mysql:

```
service mysql start

```

<br>

# Routes 🌐

ADD: http://localhost:8080

Create user:

```
ADD/user

```

Login user:

```
ADD/user/login

```

Create note:

```
ADD/note/{user_id}

```

Get note:

```
ADD/note/{user_id}

```

Update note:

```
ADD/note/{note_id}

```

Delete note:

```
ADD/note/{note_id}

```


