practice-git(模擬圖書館)

一、書籍相關操作

1. getBooks: 取得所有書
2. addBook: 增加一本書
3. deleteBook: 用bookid刪除一本書
4. deleteBookByUuid: 用uuid刪除一本書
5. editBook: 用bookid找到書先，然後修改內容
6. editBookByUuid: 用uuid找到書先，然後修改內容
7. getBook: 用bookid找到一本書
8. getBookByUuid: 用uuid找到一本書
9. getBookByName: 用書名找到一本書
10. getBookByAuthorAndName: 同時用作者和書名找到一本書
11. getBookByAuthor: 找到該作者的全部書
12. upload: 上傳檔案

二、使用者相關操作

1. register: 註冊
2. login: 登錄

三、安全性

1. 分為普通(使用者)權限及管理員權限
2. 使用需權限認證功能前須先登錄帳號密碼取得JWT token
3. 將token連同內容一併傳至服務器
