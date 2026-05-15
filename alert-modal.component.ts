<section class="hr">
  <h1>FAUX GHOST</h1>
  <p>Moda urbana · Sutil e Perspicaz</p>
  <a routerLink="/produtos" class="bpr">Ver Coleção →</a>
</section>

<section class="dst">
  <h2 class="stl">Mais Vendidos</h2>
  <div class="flt">
    <button *ngFor="let t of tipos" [class.on]="filtro === t" (click)="filtrar(t)">{{ t }}</button>
  </div>
  <div class="grd">
    <div class="cd" *ngFor="let p of filtrados">
      <img [src]="p.imagem" [alt]="p.nome" loading="lazy">
      <div class="if">
        <div class="nm">{{ p.nome }}</div>
        <div class="ds">{{ p.descricao }}</div>
        <div class="pr">R$ {{ p.preco.toFixed(2) }}</div>
        <div class="sk">{{ p.estoque }} unid.</div>
        <div class="ba">
  <button (click)="verDetalhes(p)">Comprar agora</button>
        </div>
      </div>
    </div>
  </div>
  
</section>