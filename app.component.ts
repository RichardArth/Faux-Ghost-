<nav>
  <a routerLink="/" class="logo">FAUX GHOST</a>
  <div class="nl">
    <a routerLink="/">Home</a>
    <a routerLink="/produtos">Roupas</a>
    <a routerLink="/carrinho">Carrinho</a>
    <a *ngIf="logado" (click)="irParaPerfil()" class="bp" style="cursor:pointer">Perfil</a>
    <button *ngIf="!logado" (click)="abrirLogin()">Entrar</button>
    <button *ngIf="logado" (click)="logout()">Sair</button>
  </div>
</nav>