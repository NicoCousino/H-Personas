
import React from "react";
import { BrowserRouter as Router, Route} from "react-router-dom";
import { Routes } from "react-router";
import MenuPrincipal from './Componentes/MenuPrincipal';
import AltaPersona from './Componentes/AltaPersona';
import NotFound from './Componentes/NotFound';

function App() {

  return (
    <Router>
      <Routes>
        <Route path="/" element={<MenuPrincipal/>} />
        <Route path="/AltaPersona" element={<AltaPersona/>} />
        <Route path="*" element={<NotFound/>} />
      </Routes>
    </Router>
  );
}

export default App;
