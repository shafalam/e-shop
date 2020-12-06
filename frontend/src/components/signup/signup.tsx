import React, { FormEvent } from "react"
import styles from "./signup.module.css"


const SignUp = () => {
    const onFormSubmit = (e: FormEvent<HTMLElement>) => {
        e.preventDefault()
        
        
        console.log(e.target)
    }


    return(<div>
        <form className={styles.form} onSubmit={onFormSubmit}>
            <input type="text" placeholder="Name" />
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="password" />
            <select>
                <option value="Debit Card">Debit Card</option>
                <option value="Credit Card">Credit Card</option>
                <option value="Bank transfer">Bank transfer</option>
            </select>
            <input type="number" placeholder="Balance" />
            <input type="submit" className={styles.button} />
        </form>
    </div>)
}

export default SignUp