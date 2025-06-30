import logo from './logo.svg';
import './App.css';
import MyCard from './Component/MyCard';
import './Component/MyCard.css'

function App() {
  return (
     <>
         <MyCard heading="Good Morning"/>
         <MyCard heading="Good Afternoon"/>
         <MyCard heading="Good Evening"/>
         <MyCard heading="Good Day"/>
         <MyCard heading="Good Night"/>
     </>
  );
}

export default App;
