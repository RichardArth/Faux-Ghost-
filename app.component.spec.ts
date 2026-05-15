nav {
  background: #211a21;
  padding: 10px 16px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 3px solid #4f43ae;
  position: sticky;
  top: 0;
  z-index: 10;
  flex-wrap: wrap;
  gap: 8px;
}

.logo {
  font-size: 1.5rem;
  font-weight: 800;
  color: #4f43ae;
  text-decoration: none;
  text-transform: uppercase;
  letter-spacing: 1px;
}

.nl {
  display: flex;
  gap: 12px;
  align-items: center;
  flex-wrap: wrap;
}

.nl a, .nl button {
  color: #908a99;
  text-decoration: none;
  font-weight: 600;
  background: none;
  border: none;
  font-size: 0.9rem;
  cursor: pointer;
  padding: 4px 8px;
  transition: all 0.2s;
}

.nl a:hover, .nl button:hover {
  color: #b5b6e4;
}

.bp {
  background: #4f43ae !important;
  color: #cec9cc !important;
  padding: 4px 12px !important;
}