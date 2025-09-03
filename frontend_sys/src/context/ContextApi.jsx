import { useEffect, useState } from 'react'
import ContextStore from './ContextStore'
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { toast } from 'react-toastify';

const ContextApi = (props) => {

    const [formName, setFormName] = useState("Employee");
    const navigate = useNavigate()
    const [employee, setEmployee] = useState(null)
    const [loginStatus, setLoginStatus] = useState(false)

    const fetchData = async (id) => {
        await axios.get(`http://localhost:8080/api/employee/get/${id}`)
            .then(result => setEmployee(result.data))
    }

    useEffect(() => {
        const sessionStoreData = JSON.parse(window.sessionStorage.getItem("loginPerson"))
        if (sessionStoreData) {
            setLoginStatus(true)
            fetchData(sessionStoreData.empId)
        }
    }, [loginStatus]);

    const [allEmps, setAllEmps] = useState(null)
    const fetchAllEmpData = async () => {
        await axios.get(`http://localhost:8080/api/employee/get`)
            .then(result => setAllEmps(result.data))
            .catch(e => toast.error(e.message))
    }

    useEffect(() => {
        if (loginStatus) {
            fetchAllEmpData()
        }
    }, [loginStatus])

    const contextValues = {
        formName,
        setFormName,
        navigate,
        employee,
        setEmployee,
        loginStatus,
        setLoginStatus,
        allEmps,
        setAllEmps,
    }

    return (
        <ContextStore.Provider value={contextValues}>
            {props.children}
        </ContextStore.Provider>
    )
}

export default ContextApi