import React from "react";
import "./MyCard.css"
const MyCard = (props) =>{
    console.log(props);
  return (
 <>
    <div className='card'>
            <div className='card-body'>
                <h1 className='heading'>{props.heading}</h1>
                <p>I am Java FullStack Developer</p>
            </div>
    </div>
</> 
)
};
export default MyCard;