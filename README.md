## Huong dan truy cap ung dung

- ### Truy cap truc tiep
    - Truy cap truc tiep lien ket: `https://todo-list-st8q.onrender.com/`
    - Truy cap truc tiep bang command line: `open -a "google chrome" https://todo-list-st8q.onrender.com/`

  > [!IMPORTANT]
  > Khi lan dau tien trinh chay, ung dung co the thuc hien tien trinh build. Sau khi hoan tat trinh duyet tu dong
  > dieu huong ve trang chu `/` cua ung dung.

- ### Chay ung dung bang Docker
    - Yeu cau thiet bi co Docker Desktop cho Linux/MacOS/Windows
    - Co the tai va cai dat Docker Desktop theo huong dan **[Tai Day](https://www.docker.com/products/docker-desktop/)**
    - Sau khi cai dat thanh cong, thuc hien cac buoc sau de chay ung dung bang Docker Desktop theo cac buoc:

    ````bash
    # Tao moi thu nuc
    $ mkdir -p todo-list
    
    # Sao chep reo todo-list
    $ git clone https://github.com/quangdai2207/todo_list .
    
    # Lua chon 1 trong 2 cau lenh sau de trinh chay ung dung todo-list 
    $ docker run --name todo-list -p 3000:3000 daitran9999/todo-list-app:v1.0.0
    $ docker compose up -d
    ````

  Sau khi thuc hien lenh trinh chay ung dung bang Docker, truy cap vao lien ket de test ung sung
  > 🌏 http://localhost:3000

---

## Tai lieu huong dan

Todo-list la ung dung mini voi cac chuc nang CRUD co ban duoc build tren Spring Framework Java. Moi du lieu tren ung
dung duoc luu trong bo nho Ram cua may tinh, khong su dung bat ky ket noi co so du lieu nao nhu MySql, Postgres...vv


