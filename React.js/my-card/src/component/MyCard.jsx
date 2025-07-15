import React from "react";

import "./MyCard.css"
const MyCard = (props) => {
  return (
    <>
      <div className='card'>
        <div className='card-body'>
          <h3 className='heading'>
            {props.heading}
          </h3>
          <p>
            My name is Rohit Patwa
            <br/>
            Java Full Stack developer
          </p>
        </div>

      </div>
    </>
  )
};
export default MyCard;