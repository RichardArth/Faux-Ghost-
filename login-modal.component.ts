.ft { background: #211a21; padding: 10px 14px; border-bottom: 2px solid #4f43ae; display: flex; flex-wrap: wrap; gap: 8px; }
.ft input, .ft select { padding: 8px; border: 2px solid #908a99; background: #211a21; color: #b5b6e4; font-size: 0.9rem; flex: 1; min-width: 100px; }
.ft input:focus, .ft select:focus { outline: none; border-color: #4f43ae; }
.dst { padding: 14px; flex: 1; }
.stl { font-size: 1.6rem; margin: 8px 0 14px; color: #b5b6e4; border-left: 4px solid #4f43ae; padding-left: 10px; }
.flt { display: flex; gap: 4px; margin-bottom: 14px; flex-wrap: wrap; }
.flt button { background: #211a21; border: 2px solid #908a99; color: #908a99; padding: 6px 12px; font-weight: 600; font-size: 0.8rem; cursor: pointer; transition: all 0.2s; }
.flt button.on { background: #4f43ae; color: #cec9cc; border-color: #4f43ae; }
.flt button:hover { border-color: #b5b6e4; color: #b5b6e4; }
.grd { display: grid; grid-template-columns: 1fr; gap: 14px; }
.cd { background: #211a21; border: 2px solid #908a99; display: flex; flex-direction: column; max-width: 100%; height: 100%; transition: all 0.2s; }
.cd:hover { border-color: #4f43ae; }
.cd img { width: 100%; aspect-ratio: 1/1; object-fit: cover; border-bottom: 2px solid #908a99; }
.if { padding: 8px; display: flex; flex-direction: column; flex: 1; }
.nm { font-weight: 800; color: #b5b6e4; font-size: 0.9rem; margin-bottom: 2px; }
.ds { color: #908a99; margin: 2px 0; font-size: 0.8rem; }
.pr { font-size: 1.1rem; font-weight: 900; color: #4f43ae; margin: 2px 0; }
.sk { color: #908a99; margin: 2px 0; font-weight: 600; font-size: 0.8rem; }
.ba {
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-top: auto;
  padding-top: 10px;
}
.ba button {
  padding: 10px 32px;
  font-weight: 700;
  cursor: pointer;
  border: 2px solid #4f43ae;
  font-size: 0.85rem;
  text-align: center;
  background: #4f43ae;
  color: #cec9cc;
  text-transform: uppercase;
  letter-spacing: 1px;
  transition: all 0.2s;
}
.ba button:hover { background: #b5b6e4; color: #211a21; }
@media(min-width: 600px) { .grd { grid-template-columns: repeat(2, 1fr); } }
@media(min-width: 900px) { .grd { grid-template-columns: repeat(4, 1fr); } }